package com.mapei.www.service.impl;

import com.mapei.www.dao.ProductsServiceDao;


import com.mapei.www.entity.Products;
import com.mapei.www.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsService implements IProductsService {

    @Autowired
    ProductsServiceDao productsServiceDao;

    /**
     * 获取商品列表
     * @return 商品列表
     */
    public List<Products> getProducts(){
        List<Products> list = productsServiceDao.getProducts();
        return list;
    }

}
