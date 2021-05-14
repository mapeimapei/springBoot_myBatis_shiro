package com.mapei.www.service;

import com.mapei.www.dao.TbUserDao;
import com.mapei.www.dao.UserServiceDao;
import com.mapei.www.entity.TbUser;
import com.mapei.www.entity.UserService;
import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.util.JWTUtil;
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

import com.mapei.www.entity.Properties;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
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

    @PostMapping("/addUser4")
    public ResponseData addUser4(@RequestBody UserService userService) {
        ValidatorUtils.validateEntity(userService);

        userService.UUID();
        userService.MD5Passwd();
        userServiceDao.addUser(userService);
        return new ResponseData(ExceptionMsg.SUCCESS, userService);
    }




    @PostMapping("/addUser3")
    public ResponseData addUser3(@Validated @RequestBody UserService userService ,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException("参数校验失败");
        }

        userService.UUID();
        userService.MD5Passwd();
        userServiceDao.addUser(userService);
        return new ResponseData(ExceptionMsg.SUCCESS, userService);
    }



    @PostMapping("/addUser2")
    public ResponseData addUser2(@Validated @RequestBody UserService userService) {
        userService.UUID();
        userService.MD5Passwd();
        userServiceDao.addUser(userService);
        return new ResponseData(ExceptionMsg.SUCCESS, userService);
    }





    @PostMapping("/addUser")
    public ResponseData addUser(@Validated UserService userService) {

        userService.UUID();
        userService.MD5Passwd();
        userServiceDao.addUser(userService);
        return new ResponseData(ExceptionMsg.SUCCESS, userService);
    }

    @PostMapping("/login2")
    public ResponseData login2(@RequestBody Map params) {

        String email = (String) params.get("email");
        String password = (String) params.get("password");

        System.out.println(email+password);

        String passwd = new Md5Hash(password, "mapei", 2).toString();
        UserService user = userServiceDao.getUser(email);

        if (user.getPasswd().equals(passwd)) {
            return new ResponseData(ExceptionMsg.SUCCESS, JWTUtil.sign(email, passwd));
        } else {
            return new ResponseData(ExceptionMsg.UNAUTHORIZED);
        }
    }


    @GetMapping("/test")
    public ResponseData test(
            @Length(min = 3,max = 6,message = "长度三到六")
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

        if(password.isEmpty() || null == password){
            throw new ValidationException("密码不能为空");

        }

        String passwd = new Md5Hash(password, "mapei", 2).toString();
        UserService user = userServiceDao.getUser(email);

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
