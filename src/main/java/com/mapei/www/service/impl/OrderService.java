package com.mapei.www.service.impl;

import com.mapei.www.dao.OrderServiceDao;
import com.mapei.www.entity.Order;
import com.mapei.www.entity.Products;
import com.mapei.www.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderService implements IOrderService {

    @Autowired
    OrderServiceDao orderServiceDao;

    /**
     * 添加订单
     *
     * @return row 数量
     */
    public Integer addOrder(String userid,List<Products> productList,Order order) {
        Integer n = orderServiceDao.addOrder(userid,productList,order);
        return n;
    }


    /**
     * 获取订单列表
     * @param userid
     * @return
     */
    public List<Order> getOrderList(String userid){
        List<Order> list = orderServiceDao.getOrderList(userid);
        return list;
    }

    /**
     * 删除订单
     * @param userid
     * @param orderid
     * @return
     */
    public Integer deleteOrder(String userid,String orderid){
        Integer n = orderServiceDao.deleteOrder(userid,orderid);
        return n;
    }


}
