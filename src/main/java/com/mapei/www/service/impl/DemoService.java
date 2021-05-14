package com.mapei.www.service.impl;

import com.mapei.www.dao.TbUserDao;
import com.mapei.www.entity.TbUser;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoService implements IDemoService {
    @Autowired
    TbUserDao tbUserDao;

    public ResponseData findById(String id) {
        TbUser tbUser = tbUserDao.findById(id);
        return new ResponseData(ExceptionMsg.SUCCESS, tbUser);
    }

}
