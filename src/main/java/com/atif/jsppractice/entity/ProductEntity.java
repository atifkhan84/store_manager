package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "productPurchase")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="productId")
    @NotBlank(message="ProductID is mandatory")
    private String productId;
    private String brand;
    private float discount;
    private float mrp;
    private Integer size;
    private String description;
    private Integer supplierId;
    private String payment_status;
    private Integer quantity;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
	private Timestamp purchase_timestamp;

}