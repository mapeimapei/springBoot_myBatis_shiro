package com.mapei.www.dao;

import com.mapei.www.entity.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderDetailsServiceDao {

    // 添加购物车
    public Integer addOrder(Order order);

}
