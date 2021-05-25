package com.mapei.www.dao;

import com.mapei.www.entity.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductsServiceDao {

    public List<Products> getProducts();





}
