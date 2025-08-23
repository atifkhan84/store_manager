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
import lombok.Data;

@Entity
@Table(name = "sales")
@Data
public class SalesEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String salesId;
    private String productId;
    private String brand;
    private String description;
    private Integer size;
    private Integer quantity;
    private float sellingPrice;
    private float profitLoss;
    private String paymentMode;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="sales_timestamp")
	private Timestamp salestimestamp;
    
  
}