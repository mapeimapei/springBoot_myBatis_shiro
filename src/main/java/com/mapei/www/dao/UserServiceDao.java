package com.mapei.www.dao;

import com.mapei.www.entity.User;
import com.mapei.www.result.ResponseData;
import org.springframework.stereotype.Component;

@Component
public interface UserServiceDao {

    public User getUser(String username);
    public ResponseData addUser(User user);


}
