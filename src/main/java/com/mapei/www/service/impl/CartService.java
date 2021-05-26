package com.mapei.www.service.impl;

import com.mapei.www.dao.CartServiceDao;
import com.mapei.www.entity.Cart;
import com.mapei.www.entity.Products;
import com.mapei.www.service.ICartService;
import com.mapei.www.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CartService implements ICartService {

    @Autowired
    CartServiceDao cartServiceDao;

    /**
     * 添加到购物车
     *
     * @return row 数量
     */
    public Integer addCart(Cart cart) {
        Integer n = cartServiceDao.addCart(cart);
        System.out.println(n);
        return n;
    }

    /**
     * 更新购物车
     *
     * @return row 数量
     */
    public Integer updateCart(Cart cart) {
        Integer n = cartServiceDao.updateCart(cart);
        System.out.println(n);
        return n;
    }

    /**
     * 查询购物车是否存在当前商品
     *
     * @return row 数量
     */
    public Integer selectCart(Cart cart) {
        Integer n = cartServiceDao.selectCart(cart);
        System.out.println(n);
        return n;
    }

    /**
     * 根据userid 获取用户购物车数据
     *
     * @return map
     */
    public List<Map<String, Object>> getCartList(String user_id) {
        List<Map<String, Object>> list = cartServiceDao.getCartList(user_id);
        return list;
    }


    /**
     * 删除购物车
     * @param userid
     * @param productids
     * @return
     */
    public Integer deleteCart(String userid, ArrayList<String> productids){
        Integer n = cartServiceDao.deleteCart(userid,productids);
        return n;
    }





}
