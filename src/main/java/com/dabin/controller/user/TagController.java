package com.dabin.controller.user;

import com.dabin.common.base.BaseController;
import com.dabin.common.base.ServerResponse;
import com.dabin.pojo.dto.TagVO;
import com.dabin.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签相关接口
 *
 * @author Jann Lee
 * @date 2018-11-21 0:03
 **/
@Api("标签/分类相关接口")
@RequestMapping("tags")
@RestController
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    @GetMapping("/{type:\\d+}")
    @ApiOperation(value = "获取标签列表", response = TagVO.class, responseContainer = "List")
    public ServerResponse<List<TagVO>> getTagList(@PathVariable Integer type) {

        return tagService.getAllTagListInfsByType(type);
    }
}
