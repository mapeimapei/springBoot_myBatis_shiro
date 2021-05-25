package com.mapei.www.web.shop;


import com.mapei.www.entity.Products;
import com.mapei.www.entity.Cart;
import com.mapei.www.service.impl.ProductsService;
import com.mapei.www.service.impl.CartService;
import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
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

    @Autowired
    CartService cartService;

    /**
     * @return
     */
    @PostMapping("cart/addCart")
    public ResponseData addCart(@Validated @RequestBody Cart cart) {
        Integer selectCart = cartService.selectCart(cart);
        Integer n;
        if (selectCart > 0) {
            System.out.println("更新");
            n = cartService.updateCart(cart);

        } else {
            System.out.println("add");
            n = cartService.addCart(cart);
        }
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }

    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("cart/getCartList/{user_id}")
    public ResponseData getCartList(@PathVariable("user_id") String user_id) {
        List<Map<String, Object>> list = cartService.getCartList(user_id);
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("products")
    public ResponseData getProducts() {
        List<Products> list = productsService.getProducts();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


}
