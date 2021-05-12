package com.mapei.www.dao;

import com.mapei.www.entity.Login;
import org.springframework.stereotype.Component;

@Component
public interface LoginDao {
    public Login getUser(String email);


}
