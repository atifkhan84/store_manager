package com.atif.jsppractice.bean;

@lombok.Data
public class ProductBean {

    private Integer id;
    private String productId;
    private String brand;
    private double discount;
    private double mrp;
    private Integer size;
    private String description;
    private Integer supplierId;
    private String payment_status;

}