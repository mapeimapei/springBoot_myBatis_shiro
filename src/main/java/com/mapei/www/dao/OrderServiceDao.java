package com.mapei.www.dao;

import com.mapei.www.entity.Order;
import com.mapei.www.entity.Products;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public interface OrderServiceDao {

    // 生成订单
    public Integer addOrder(String userid,List<Products> productList,Order order, String fast);

    // 获取订单列表
    public List<Order> getOrderList(String userid);

    // 删除订单
    public Integer deleteOrder(String userid,String orderid);




}
