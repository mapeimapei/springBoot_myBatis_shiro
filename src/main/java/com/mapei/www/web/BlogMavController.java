package com.mapei.www.web;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.mapei.www.entity.Post;
import com.mapei.www.service.impl.PostService;
import com.mapei.www.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.*;

@Controller
public class BlogMavController {

    @Autowired
    PostService postService;

    @GetMapping("/index")
    public String index(Model m, @RequestParam(value="start",defaultValue="0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"created_at desc");
        List<Post> cs = postService.getPost();
        PageInfo<Post> page = new PageInfo<>(cs);
        System.out.println(page);
        m.addAttribute("page", page);
        return "index";
    }
}
