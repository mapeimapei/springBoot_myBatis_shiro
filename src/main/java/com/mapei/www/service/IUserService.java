package com.mapei.www.service;

import com.mapei.www.entity.User;

import java.util.List;

public interface IUserService {


    /**
     *
     * @param username
     * @return
     */
    public User getUser(String username);

}
