package com.mapei.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapei.www.entity.Properties;

import java.util.List;

@RestController
public class HelloWorld {

    @Autowired
    Properties properties;

    @RequestMapping("hello")
    public String hello(){
        return "Hello,Spring Boot!";
    }

    @RequestMapping("hello2")
    public String hello2(){
        return properties.getAge();
    }

    @RequestMapping("address")
    public List<String> address(){
        return properties.getAddress();
    }


}
