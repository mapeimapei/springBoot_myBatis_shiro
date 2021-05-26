package com.mapei.www.service;

import com.mapei.www.entity.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ICartService {
    /**
     * 添加到购物车
     * @return 增加条数
     */
    public Integer addCart(Cart cart);

    /**
     * 更新购物车
     *
     * @return 增加条数
     */
    public Integer updateCart(Cart cart);

    /**
     * 查询购物车是否存在当前商品
     * @param cart
     * @return
     */
    public Integer selectCart(Cart cart);

    /**
     * 根据userid 获取用户购物车数据
     * @return map
     */
    public List<Map<String,Object>> getCartList(String user_id);

    /**
     * 删除购物车
     * @param userid
     * @param productids
     * @return
     */
    public Integer deleteCart(String userid, ArrayList<String> productids);


}
