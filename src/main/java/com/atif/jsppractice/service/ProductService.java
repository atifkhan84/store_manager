package com.atif.jsppractice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.atif.jsppractice.bean.ProductBean;
import com.atif.jsppractice.entity.ProductEntity;
import com.atif.jsppractice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductEntity getProductByProductId(String productId) {
		return productRepository.findProductByProductId(productId);
	}
	
	public List<ProductEntity> getAllProducts(){
		return (List<ProductEntity>) productRepository.findAll();
	}
	public List<ProductEntity> getAllProductDetails(){
		return productRepository.getAllProductDetails();
	}
	
	public ProductEntity addProductPurchase(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}
	
	public List<ProductEntity> getProductPurchaseInDescOrderByDate(){
		return productRepository.getProductPurchaseInDescOrderByDate();
	}

	public Map<String, String> getProductIdAndBrand() {
		// TODO Auto-generated method stub
		Map<String, String> productIdAndBrand = new HashMap<String, String>();
		return null;
	}
}
  	