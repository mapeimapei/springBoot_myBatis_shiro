package com.mapei.www.dao;

import com.mapei.www.entity.Order;
import com.mapei.www.entity.Products;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public interface OrderServiceDao {


    // 添加购物车
    public Integer addOrder(String userid,List<Products> productList,Order order);

}