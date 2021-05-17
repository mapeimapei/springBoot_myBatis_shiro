package com.mapei.www.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
 解决静态资源不能访问
 */
@Controller
@SpringBootApplication
public class StaticPath extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
