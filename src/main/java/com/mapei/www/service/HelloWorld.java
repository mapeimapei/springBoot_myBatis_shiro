package com.mapei.www.service;

import com.mapei.www.dao.TbUserDao;
import com.mapei.www.entity.TbUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapei.www.entity.Properties;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户信息管理")
public class HelloWorld {

    @Autowired
    Properties properties;

    @Autowired
    TbUserDao tbUserDao;

    @GetMapping("selectUser")
    public List<TbUser> selectUser(){
        return tbUserDao.SelectTbUser();
    }

    @ApiOperation(value = "一个演示接口", notes = "这里是描述")
    @GetMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot!";
    }

    @GetMapping("hello2")
    public String hello2(){
        return properties.getAge();
    }

    @GetMapping("address")
    public List<String> address(){
        return properties.getAddress();
    }


}
