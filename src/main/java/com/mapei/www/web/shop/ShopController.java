package com.mapei.www.web.shop;


import com.mapei.www.entity.Products;
import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.mapei.www.service.impl.ProductsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/shop/")
@Api(value = "宠物商店控制器")
public class ShopController {

    @Autowired
    ProductsService productsService;

    /**
     * @return
     */
    @GetMapping("products")
    public ResponseData getProducts() {
        List<Products> list = productsService.getProducts();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


}
