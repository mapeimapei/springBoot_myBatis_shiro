package com.mapei.www.service;


import com.mapei.www.entity.Order;
import com.mapei.www.entity.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IOrderService {
    /**
     * 生成订单
     * @return 增加条数
     */
    public Integer addOrder(String userid,List<Products> productList,Order order);


}
