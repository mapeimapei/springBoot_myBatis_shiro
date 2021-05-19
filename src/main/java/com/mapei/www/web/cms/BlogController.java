package com.mapei.www.web.cms;


import com.mapei.www.entity.Post;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/cms/")
@Api(value = "博客模块的Api")
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping("post/getPosts")
    public ResponseData getPosts() {
        List<Post> cs = postService.getPost();
        String[] fields = {
                "name",
                "post_id",
                "user_name",
                "content",
                "created_at",
                "summary"
        };
        return new ResponseData(ExceptionMsg.SUCCESS, cs, fields);
    }

}
