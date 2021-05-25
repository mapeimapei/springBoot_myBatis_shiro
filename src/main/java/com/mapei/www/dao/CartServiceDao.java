package com.mapei.www.dao;

import com.mapei.www.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartServiceDao {
    //查询购物车是否存在当前商品
    public Integer selectCart(Cart cart);

    // 添加购物车
    public Integer addCart(Cart cart);

    // 更新购物车
    public Integer updateCart(Cart cart);


}
