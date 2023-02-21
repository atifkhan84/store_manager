package com.atif.jsppractice.entity;

import java.io.Serializable;
import java.util.Objects;

public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String brand;
	private Integer size;
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
	@Override
	public int hashCode() {
		return Objects.hash(brand, productId, size);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(productId, other.productId)
				&& Objects.equals(size, other.size);
	}
	
	
}