package com.mapei.www.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetails {

    private String orderid;
    private String orderdate;
    private int status = 0;
    private Double amount;
    private List<OrderList> orderList;


}
