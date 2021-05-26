package com.mapei.www.web.shop;


import com.alibaba.fastjson.JSONObject;
import com.mapei.www.entity.Products;
import com.mapei.www.entity.Cart;
import com.mapei.www.entity.Order;
import com.mapei.www.entity.OrderDetails;
import com.mapei.www.service.impl.ProductsService;
import com.mapei.www.service.impl.CartService;

import com.mapei.www.service.impl.OrderService;

import com.mapei.www.exception.ValidatorUtils;
import com.mapei.www.result.ExceptionMsg;
import com.mapei.www.result.ResponseData;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.alibaba.fastjson.JSON.toJSONString;

@RestController
@Validated
@RequestMapping("/api/shop/")
@Api(value = "宠物商店控制器")
public class ShopController {

    @Autowired
    ProductsService productsService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;


    /**
     * @return
     */
    @PostMapping("cart/addCart")
    public ResponseData addCart(@Validated @RequestBody Cart cart) throws Exception {
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
     *
     * @return
     */
    @GetMapping("cart/getCartList/{user_id}")
    public ResponseData getCartList(@PathVariable("user_id") String user_id) throws Exception {
        List<Map<String, Object>> list = cartService.getCartList(user_id);
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("products")
    public ResponseData getProducts() throws Exception {
        List<Products> list = productsService.getProducts();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }

    /**
     * 删除购物车
     *
     * @param params
     * @return
     */

    @PostMapping("cart/deleteCart")
    public ResponseData deleteCart(@RequestBody Map params) throws Exception {
        String userid = (String) params.get("userid");
        ArrayList<String> productids = (ArrayList<String>) params.get("productids");
        Integer n = cartService.deleteCart(userid, productids);
        System.out.println(n);
        if (n > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }

    }

    /**
     * 生成订单
     * @return
     */
    @PostMapping("order/addOrder")
    public ResponseData addCart(@RequestBody Map params) throws Exception {
        String userid = (String) params.get("userid");
        List<Products> productList = (List<Products>) params.get("productList");

        Order order = new Order();
        String uuid = UUID.randomUUID().toString();
        String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String created_at = new SimpleDateFormat(TIME_FORMAT).format(new Date());

        order.setOrderid(uuid);
        order.setUserid(userid);
        order.setOrderdate(created_at);

        Double amount = 0.0;
        for(Object obj : productList){
            Products products = JSONObject.parseObject(toJSONString(obj),Products.class);
            Double price = products.getListprice() * products.getQuantity();
            amount += price;
        }

        order.setAmount(amount);

        int n =  orderService.addOrder(userid,productList,order);
        System.out.println(n);

        if (n > 0) {
            Map<String,String> res = new HashMap<>();
            res.put("orderid",uuid);
            return new ResponseData(ExceptionMsg.SUCCESS,res);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }










}
