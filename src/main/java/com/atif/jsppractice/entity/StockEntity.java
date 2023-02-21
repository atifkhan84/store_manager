package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

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

	public Timestamp getStockTimestamp() {
		return stockTimestamp;
	}

	public void setStockTimestamp(Timestamp stockTimestamp) {
		this.stockTimestamp = stockTimestamp;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
	public String toString() {
		return "StockEntity [productId=" + productId + ", brand=" + brand + ", description=" + description + ", size="
				+ size + ", quantity=" + quantity + "]";
	}

}

