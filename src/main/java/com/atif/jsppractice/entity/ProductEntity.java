package com.atif.jsppractice.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productPurchase")
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

    public Timestamp getPurchase_timestamp() {
		return purchase_timestamp;
	}

	public void setPurchase_timestamp(Timestamp purchase_timestamp) {
		this.purchase_timestamp = purchase_timestamp;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", productId=" + productId + ", brand=" + brand + ", discount=" + discount
				+ ", mrp=" + mrp + ", size=" + size + ", description=" + description + ", supplierId=" + supplierId
				+ ", payment_status=" + payment_status + ", quantity=" + quantity + ", purchase_timestamp="
				+ purchase_timestamp + "]";
	}
    
}