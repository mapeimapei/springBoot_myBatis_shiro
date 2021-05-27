package com.mapei.www.service;

import com.mapei.www.entity.OrderDetails;

import java.util.List;

public interface IOrderDetailsService {
    /**
     * 查询订单详情
     * @return 查询订单详情
     */
    public OrderDetails queryOrdersDetails(String userid,String orderid);


}
