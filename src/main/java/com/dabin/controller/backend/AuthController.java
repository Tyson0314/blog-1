package com.dabin.controller.backend;

import com.dabin.common.Result;
import com.dabin.common.base.BaseController;
import com.dabin.common.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import com.dabin.common.constants.SystemConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author: 程序员大彬
 * @time: 2021-11-06 16:27
 */
@RestController
@RequestMapping("/oauth")
@Api(value = "第三方登录相关接口", tags = {"第三方登录相关接口"})
@Slf4j
public class AuthController extends BaseController {

    @Value(value = "${justAuth.clientId.gitee}")
    private String giteeClienId;

    @Value(value = "${justAuth.clientSecret.gitee}")
    private String giteeClientSecret;

    @Value(value = "${webSite.url}")
    private String webSiteUrl;

    @Value(value = "${blog.web.url}")
    private String blogUrl;




    @ApiOperation(value = "获取认证", notes = "获取认证")
    @RequestMapping("/render/{source}")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        // 将传递过来的转换成大写
//        Boolean isOpenLoginType = webConfigService.isOpenLoginType(source.toUpperCase());
//        if (!isOpenLoginType) {
//            return ResultUtil.result(SysConf.ERROR, "后台未开启该登录方式!");
//        }
//        log.info("进入render:" + source);
//        AuthRequest authRequest = getAuthRequest(source);
//        String token = AuthStateUtils.createState();
//        String authorizeUrl = authRequest.authorize(token);
//        Map<String, String> map = new HashMap<>();
//        map.put("url", authorizeUrl);
//        return Result.success(map);
        log.info("进入render：" + source);
        AuthRequest authRequest = getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        log.info(authorizeUrl);
        response.sendRedirect(authorizeUrl);
    }


    /**
     * oauth平台中配置的授权回调地址，以本项目为例，在创建gitee授权应用时的回调地址应为：http://127.0.0.1:8603/oauth/callback/gitee
     */
    @RequestMapping("/callback/{source}")
    public void login(@PathVariable("source") String source, AuthCallback callback, HttpServletResponse httpServletResponse) throws IOException {
        log.info("进入callback：" + source + " callback params：" + JSONObject.toJSONString(callback));
        AuthRequest authRequest = getAuthRequest(source);
        AuthResponse response = authRequest.login(callback);
        if (response.getCode() == SystemConstant.RESULT_CODE_5000) {
            // 跳转到500错误页面
            httpServletResponse.sendRedirect(webSiteUrl + SystemConstant.ERROR_500);
            return;
        }
        String result = JSONObject.toJSONString(response);
        Map<String, Object> map = JsonUtils.jsonToMap(result);
        Map<String, Object> data = JsonUtils.jsonToMap(JsonUtils.objectToJson(map.get(SystemConstant.DATA)));
        Map<String, Object> token = new HashMap<>();
        String accessToken = "";
        if (data == null || data.get(SystemConstant.TOKEN) == null) {
            // 跳转到500错误页面
            httpServletResponse.sendRedirect(webSiteUrl + SystemConstant.ERROR_500);
            return;
        } else {
            token = JsonUtils.jsonToMap(JsonUtils.objectToJson(data.get(SystemConstant.TOKEN)));
            accessToken = token.get(SystemConstant.ACCESS_TOKEN).toString();
        }

        //todo 存用户信息

        httpServletResponse.sendRedirect(webSiteUrl + "?token=" + accessToken);
    }

    private AuthRequest getAuthRequest(String source) {
        log.info("blogUrl:{}, source:{}", blogUrl, source);
        AuthRequest authRequest = null;
        switch (source.toLowerCase()) {
            case SystemConstant.GITEE:
                authRequest = new AuthGiteeRequest(AuthConfig.builder()
                        .clientId(giteeClienId)
                        .clientSecret(giteeClientSecret)
                        .redirectUri(blogUrl + "/oauth/callback/gitee")
                        .build());
                break;
            default:
                break;
        }
        if (null == authRequest) {
            throw new AuthException("不存在的认证方式");
        }
        return authRequest;
    }

}
