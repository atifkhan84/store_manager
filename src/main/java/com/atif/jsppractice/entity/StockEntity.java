package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@lombok.Data
@Entity
@Table(name = "stock")
@IdClass(Stock.class)
public class StockEntity {
	
	@Id
    private String productId;
	@Id
    private String brand;
    private String description;
    @Id
    private Integer size;
    private Integer quantity;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Timestamp stockTimestamp;

}

