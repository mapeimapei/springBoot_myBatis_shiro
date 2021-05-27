package com.mapei.www.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class Order {

    @NotBlank(message = "userid不能为空")
    private String userid;

    @NotBlank(message = "商品id不能为空")
    private String orderid;

    @NotBlank(message = "订单日期不能为空")
    private String orderdate;


    private int status = 0;

    private Double amount;



}
