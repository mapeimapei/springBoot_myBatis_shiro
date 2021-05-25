package com.mapei.www.service;

import com.mapei.www.entity.Cart;

import java.util.List;

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




}
