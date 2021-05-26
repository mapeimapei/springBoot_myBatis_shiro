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
        System.out.println(n);
        return n;
    }

}
