package com.mapei.www.service;

import com.mapei.www.dao.LoginDao;
import com.mapei.www.dao.TbUserDao;
import com.mapei.www.dao.UserServiceDao;
import com.mapei.www.entity.Login;
import com.mapei.www.entity.TbUser;
import com.mapei.www.entity.UserService;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mapei.www.entity.Properties;

import java.io.IOException;
import java.util.List;

@RestController
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
    LoginDao loginDao;


    @PostMapping("/addUser")
    public ResponseData addUser(UserService userService) {
        userService.setUser_id();
        userServiceDao.addUser(userService);
        return new ResponseData(ExceptionMsg.SUCCESS, userService);
    }


    @PostMapping("/login")
    public ResponseData login(@RequestParam("email") String email,
                              @RequestParam("password") String password) {


        Md5Hash passwd = new Md5Hash(password, "mapei", 2);
        Login user = loginDao.getUser(email);

        if (user.getPasswd().equals(String.valueOf(passwd))) {
            return new ResponseData(ExceptionMsg.SUCCESS, JWTUtil.sign(email, String.valueOf(passwd)));
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

    @GetMapping("selectUser2")
    public ResponseData selectUser2() {
        List<TbUser> list = tbUserDao.SelectTbUser();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
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
