package com.dabin.controller.user;

import com.dabin.common.base.BaseController;
import com.dabin.common.base.ServerResponse;
import com.dabin.pojo.dto.CommentAddRequest;
import com.dabin.pojo.dto.CommentListRequest;
import com.dabin.pojo.vo.CommentListItemVO;
import com.dabin.service.CommentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 评论相关接口
 *
 * @author Jann Lee
 * @date 2018-11-20 12:20
 **/
@Api(description = "用户评论模块")
@RequestMapping("comments")
@CrossOrigin
@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation(value = "添加评论")
    public ServerResponse addComment(@RequestBody CommentAddRequest commentAddRequest) {
        validate(commentAddRequest);
        return commentService.addCommentInfo(commentAddRequest);
    }

    @GetMapping("/{targetId:\\d+}")
    @ApiOperation(value = "获取评论列表", responseContainer = "PageInfo", response = CommentListItemVO.class)
    public ServerResponse<PageInfo<CommentListItemVO>> getCommentListInfos(@PathVariable Integer targetId, CommentListRequest commentListRequest) {

        return commentService.getCommentInfos(targetId, commentListRequest);
    }
    @PutMapping("/like/{commentId:\\d+}")
    @ApiOperation(value = "给评论点赞", responseContainer = "PageInfo", response = Boolean.class)
    public ServerResponse<String> addLikeCount(
           @ApiParam(value ="评论的id") @PathVariable(value = "commentId") Integer id){

        return commentService.addCommentLikeCount(id);
    }

}
