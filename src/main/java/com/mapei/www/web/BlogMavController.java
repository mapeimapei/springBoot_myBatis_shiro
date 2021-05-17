package com.mapei.www.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapei.www.entity.Post;
import com.mapei.www.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class BlogMavController {

    @Autowired
    PostService postService;

    /**
     *获取文章列表
     * @param m
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/index")
    public String index(Model m, @RequestParam(value="start",defaultValue="0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"created_at desc");
        List<Post> cs = postService.getPost();
        PageInfo<Post> page = new PageInfo<>(cs);
        System.out.println(page);
        m.addAttribute("page", page);
        return "index";
    }

    /**
     * 获取文章详情
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/single")
    public ModelAndView index( @RequestParam String id) throws Exception {
        Post post = postService.queryPostById(id);
        ModelAndView modelAndView = new ModelAndView("single");
        modelAndView.addObject("post", post);
        return modelAndView;
    }


}