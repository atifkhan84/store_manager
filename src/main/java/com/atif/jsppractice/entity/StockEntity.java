package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@lombok.Data
@Entity
@Table(name = "stock")
@IdClass(Stock.class)  //@IdClass is used when an entity has a composite primary key
public class StockEntity {
	
	@Id
    private String productId;
	@Id
    private String brand;
    private String description;
    @Id
    private Integer size;
    private Integer quantity;
    
    @Temporal(TemporalType.TIMESTAMP)  //Makes sure that JPA knows this is a full date-time field (not just date or time).
    @CreationTimestamp   //When the entity is saved, Hibernate will automatically fill stockTimestamp with the current date and time.
    private Timestamp stockTimestamp;

}

