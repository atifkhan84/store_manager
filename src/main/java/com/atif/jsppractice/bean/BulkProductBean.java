package com.atif.jsppractice.bean;

import java.util.List;

import lombok.Data;

@Data
public class BulkProductBean {
	
    private String productId;
    private String brand;
    private float discount;
    private float mrp;
    private List<Integer> size;
    private List<Integer> quantity;
    private String description;
    private Integer supplierId;
    private String paymentStatus;

	
}