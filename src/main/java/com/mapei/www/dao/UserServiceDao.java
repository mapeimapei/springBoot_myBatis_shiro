package com.mapei.www.dao;

import com.mapei.www.entity.UserService;
import com.mapei.www.result.ResponseData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserServiceDao {

    public UserService getUser(String username);
    public ResponseData addUser(UserService userService);


}
