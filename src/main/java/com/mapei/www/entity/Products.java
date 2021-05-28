package com.mapei.www.entity;
import lombok.Data;

@Data
public class Products {
    private String category;
    private String cname;
    private String descn;
    private String ename;
    private String image;
    private String productid;
    private Double listprice;
    private Double unitcost;
    private Integer quantity;

}
