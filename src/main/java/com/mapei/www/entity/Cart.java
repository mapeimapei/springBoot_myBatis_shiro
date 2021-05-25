package com.mapei.www.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Cart {

    @NotBlank(message = "userid不能为空")
    private String userid;

    @NotBlank(message = "商品id不能为空")
    private String productid;


    // @Min(value = 1)
    // @Max(value = 10)
    @Range(min = 1, max = 10, message = "数量范围1~5")
    private Integer quantity;
}
