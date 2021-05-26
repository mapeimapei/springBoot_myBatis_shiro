package com.mapei.www.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderDetails {

    @NotBlank(message = "orderid不能为空")
    private String orderid;

    @NotBlank(message = "商品id不能为空")
    private String productid;

    @NotBlank(message = "商品数量")
    private int quantity;


    private Double unitcost;

}
