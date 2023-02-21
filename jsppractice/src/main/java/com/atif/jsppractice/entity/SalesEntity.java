package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
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
    
    public Timestamp getSalestimestamp() {
		return salestimestamp;
	}

	public void setSalestimestamp(Timestamp salestimestamp) {
		this.salestimestamp = salestimestamp;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(float profitLoss) {
		this.profitLoss = profitLoss;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
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

}