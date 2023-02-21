package com.atif.jsppractice.bean;

import java.util.List;

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
	public List<Integer> getSize() {
		return size;
	}
	public void setSize(List<Integer> size) {
		this.size = size;
	}
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "BulkProductBean [productId=" + productId + ", brand=" + brand + ", discount=" + discount + ", mrp="
				+ mrp + ", size=" + size + ", quantity=" + quantity + ", description=" + description + ", supplierId="
				+ supplierId + ", paymentStatus=" + paymentStatus + "]";
	}
	
}