package com.dabin.controller.backend;

import com.dabin.common.base.ServerResponse;
import com.dabin.common.base.BaseController;
import com.dabin.pojo.dto.UserLoginRequest;
import com.dabin.common.security.SecurityUserDetail;
import com.dabin.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员登录controller
 *
 * @author liqiang
 * @datetime 2019/8/7 15:34
 **/
@RestController
@RequestMapping
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value ="登录")
    public ServerResponse<String> login(@RequestBody UserLoginRequest userLoginRequest){
        validate(userLoginRequest);

        return userService.login(userLoginRequest);
    }
    @GetMapping("/logout")
    @ApiOperation(value ="登出")
    public ServerResponse<Boolean> logout(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("X-Token", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ServerResponse.createBySuccess(Boolean.TRUE);
    }


    @GetMapping("/manage/system/user")
    public ServerResponse<SecurityUserDetail> getUserInfo(){
        SecurityUserDetail securityUserDetail = new SecurityUserDetail();
        securityUserDetail.setId(1L);
        securityUserDetail.setUserName("李强");
        securityUserDetail.setRole("ROLE_ADMIN");

        return ServerResponse.createBySuccess(securityUserDetail);
    }

}
