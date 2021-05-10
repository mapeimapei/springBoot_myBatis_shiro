package com.mapei.www.dao;

import com.mapei.www.entity.TbUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbUserDao {

    List<TbUser> SelectTbUser();


}
