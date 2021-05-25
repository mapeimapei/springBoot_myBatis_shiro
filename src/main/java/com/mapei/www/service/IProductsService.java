package com.mapei.www.service;

import com.mapei.www.entity.Products;

import java.util.List;

public interface IProductsService {
    /**
     * 获取文章列表
     * @return 文章列表List
     */
    public List<Products> getProducts();


}
