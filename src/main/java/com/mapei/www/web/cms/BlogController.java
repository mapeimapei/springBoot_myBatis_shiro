package com.mapei.www.web.cms;


import com.mapei.www.entity.Post;
import com.mapei.www.entity.User;
import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.PostService;
import io.swagger.annotations.Api;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/cms/")
@Api(value = "博客模块的Api")
public class BlogController {

    @Autowired
    PostService postService;

    /**
     *
     * @return
     */
    @GetMapping("post/getPosts")
    public ResponseData getPosts() {
        List<Post> cs = postService.getPost();
        String[] fields = {
                "name",
                "post_id",
                "user_name",
                "created_at",
                "summary"
        };
        return new ResponseData(ExceptionMsg.SUCCESS, cs, fields);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("post/getSingleById/{id}")
    public ResponseData getSingleById(@PathVariable String id) {
        Post post= postService.queryPostById(id);
        return new ResponseData(ExceptionMsg.SUCCESS, post);
    }

    @PostMapping("post/addSingle")
    public ResponseData addSingle(@RequestBody Post post) {
        ValidatorUtils.validateEntity(post);
        post.curTime();

        Post ps = null;
        if(post.getId().isEmpty() || post.getId() == null){
            post.UUID();
            ps= postService.addSingle(post);

        }else{
            ps= postService.updateSingle(post);
        }

        return new ResponseData(ExceptionMsg.SUCCESS, ps);
    }

    @PostMapping("/post/deleteSingle")
    public ResponseData login2(@RequestBody Map params) {

        String id = (String) params.get("id");

        try{
            postService.deleteSingle(id);
            return new ResponseData(ExceptionMsg.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseData(ExceptionMsg.FAILED);
        }



//        String n = postService.deleteSingle(id);
//
//        if(n.equals("1")){
//            System.out.println(n);
//            return new ResponseData(ExceptionMsg.SUCCESS);
//        }else{
//            return new ResponseData(ExceptionMsg.FAILED);
//        }



    }



}
