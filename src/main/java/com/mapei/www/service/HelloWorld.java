package com.mapei.www.service;

import com.mapei.www.dao.TbUserDao;
import com.mapei.www.dao.UserServiceDao;
import com.mapei.www.entity.*;
import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.PostService;
import com.mapei.www.util.JWTUtil;
import com.mapei.www.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
@Api(value = "用户信息管理")
public class HelloWorld {

    @Autowired
    Properties properties;

    @Autowired
    TbUserDao tbUserDao;


    @Autowired
    UserServiceDao userServiceDao;

    @Autowired
    PostService postService;

    @GetMapping("selectUser5")
    public ResponseData selectUser5() {
        List<Post> cs = postService.getPost();
        String[] fields = {"name", "post_id", "user_name"};
        return new ResponseData(ExceptionMsg.SUCCESS, cs, fields);
    }


    @GetMapping("selectUser4")
    public ResponseData selectUser4() {
        List<Post> cs = postService.getPost();

//        String jsonStr = JSONObject.toJSONString(cs);
//        Object cc = JSONObject.parse(jsonStr);
//        List<Post> res = JSONArray.parseArray(jsonStr.trim(), Post.class);
//        String[] includeAttributes = {"name","post_id","user_name"};
//        Object ll = Utils.filterResult(cs, includeAttributes);
        return new ResponseData(ExceptionMsg.SUCCESS, cs);
    }


    @RequestMapping(value = "/fastjson", method = RequestMethod.POST)
    public ResponseData fastjson(@RequestBody FastjsonTest vo) {

        vo.setIgnore("ignore field");
        vo.setDate(new Date());

        return new ResponseData(ExceptionMsg.SUCCESS, vo);
    }

    @RequestMapping(value = "/fastjson2", method = RequestMethod.POST)
    public ResponseData fastjson2(@RequestBody FastjsonTest vo) {
        vo.setIgnore("ignore field");
        vo.setDate(new Date());
        String[] includeAttributes = {"post_id", "string"};


        return new ResponseData(ExceptionMsg.SUCCESS, Utils.filterResult(vo, includeAttributes));
    }


    @GetMapping("selectUser3")
    public ResponseData selectUser3() {
        List<TbUser> list = tbUserDao.SelectTbUser();
        String[] includeAttributes = {"name", "email"};
        Object ll = Utils.filterResult(list, includeAttributes);
        return new ResponseData(ExceptionMsg.SUCCESS, ll);
    }


    @GetMapping("selectUser2")
    public ResponseData selectUser2() {
        List<TbUser> list = tbUserDao.SelectTbUser();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }

    @PostMapping("/addUser4")
    public ResponseData addUser4(@RequestBody User user) {
        ValidatorUtils.validateEntity(user);

        user.UUID();
        user.MD5Passwd();
        userServiceDao.addUser(user);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }


    @PostMapping("/addUser3")
    public ResponseData addUser3(@Validated @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException("参数校验失败");
        }

        user.UUID();
        user.MD5Passwd();
        userServiceDao.addUser(user);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }


    @PostMapping("/addUser2")
    public ResponseData addUser2(@Validated @RequestBody User user) {
        user.UUID();
        user.MD5Passwd();
        userServiceDao.addUser(user);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }


    @PostMapping("/addUser")
    public ResponseData addUser(@Validated User user) {

        user.UUID();
        user.MD5Passwd();
        userServiceDao.addUser(user);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    @PostMapping("/login2")
    public ResponseData login2(@RequestBody Map params) {

        String email = (String) params.get("email");
        String password = (String) params.get("password");

        System.out.println(email + password);

        String passwd = new Md5Hash(password, "mapei", 2).toString();
        User user = userServiceDao.getUser(email);

        if (user.getPasswd().equals(passwd)) {
            return new ResponseData(ExceptionMsg.SUCCESS, JWTUtil.sign(email, passwd));
        } else {
            return new ResponseData(ExceptionMsg.UNAUTHORIZED);
        }
    }


    @GetMapping("/test")
    public ResponseData test(
            @Length(min = 3, max = 6, message = "长度三到六")
            @RequestParam String name,
            @Email
            @RequestParam String email
    ) {

        System.out.println(name);
        System.out.println(email);

        return new ResponseData(ExceptionMsg.SUCCESS, null);
    }


    @PostMapping("/login")
    public ResponseData login(
            String email,
            String password) {

        if (password.isEmpty() || null == password) {
            throw new ValidationException("密码不能为空");

        }

        String passwd = new Md5Hash(password, "mapei", 2).toString();
        User user = userServiceDao.getUser(email);

        if (user.getPasswd().equals(passwd)) {
            return new ResponseData(ExceptionMsg.SUCCESS, JWTUtil.sign(email, passwd));
        } else {
            return new ResponseData(ExceptionMsg.UNAUTHORIZED);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseData requireAuth() {
        return new ResponseData(ExceptionMsg.SUCCESS, null);
    }


    @GetMapping("/require_role")
    @RequiresRoles("0")
    public ResponseData requireRole() {
        return new ResponseData("200", "You are visiting require_role", null);
    }


    @GetMapping("selectUser")
    public List<TbUser> selectUser() {
        return tbUserDao.SelectTbUser();
    }


    //查
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData findArticle(@PathVariable("id") String id) throws IOException {
        TbUser user = tbUserDao.findById(id);
        if (user != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, user);
        }
        return new ResponseData(ExceptionMsg.FAILED, user);
    }


    @ApiOperation(value = "一个演示接口", notes = "这里是描述")
    @GetMapping("/hello")
    public String hello() {
        return "Hello,Spring Boot!";
    }

    @GetMapping("hello2")
    public String hello2() {
        return properties.getAge();
    }

    @GetMapping("address")
    public List<String> address() {
        return properties.getAddress();
    }


}
