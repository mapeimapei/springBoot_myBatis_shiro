package com.mapei.www.dao;

import com.mapei.www.entity.OrderDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public interface OrderDetailsServiceDao {

    // 查询订单详情
    public OrderDetails queryOrdersDetails(String userid,String orderid);


}
