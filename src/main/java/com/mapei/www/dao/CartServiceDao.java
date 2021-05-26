package com.mapei.www.dao;

import com.mapei.www.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public interface CartServiceDao {
    //查询购物车是否存在当前商品
    public Integer selectCart(Cart cart);

    // 添加购物车
    public Integer addCart(Cart cart);

    // 更新购物车
    public Integer updateCart(Cart cart);

    // 根据userid 获取用户购物车数据
    public List<Map<String,Object>> getCartList(String user_id);

    // 删除购物车
    public Integer deleteCart(String userid, ArrayList<String> productids);
}
