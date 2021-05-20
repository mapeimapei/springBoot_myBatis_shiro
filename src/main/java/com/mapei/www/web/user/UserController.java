package com.mapei.www.web.user;


import com.mapei.www.entity.User;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.PostService;
import com.mapei.www.service.impl.UserService;
import com.mapei.www.util.JWTUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

import com.mapei.www.util.Utils;

@RestController
@Validated
@RequestMapping("/api/user")
@Api(value = "博客模块的Api")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseData login(@RequestBody Map params) {

        String email = (String) params.get("account");
        String password = (String) params.get("passwd");

        System.out.println(email + password);

        if (password.isEmpty() || null == password) {
            throw new ValidationException("密码不能为空");
        }

        String passwd = new Md5Hash(password, "mapei", 2).toString();
        User user = userService.getUser(email);

        if (user.getPasswd().equals(passwd)) {
            Map<String, Object> addProperties = new HashMap();
            addProperties.put("token", JWTUtil.sign(email, passwd));
            Object loginInf = Utils.Assgin(user, addProperties);

            String[] keys = {"user_id", "name", "email", "token", "admin"};

            return new ResponseData(ExceptionMsg.SUCCESS, loginInf, keys);
        } else {
            return new ResponseData(ExceptionMsg.UNAUTHORIZED);
        }


    }

}
