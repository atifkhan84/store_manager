package com.atif.jsppractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atif.jsppractice.entity.StockEntity;
import com.atif.jsppractice.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	public List<StockEntity> getStockByProductId(String productId) {
		return stockRepository.findByProductId(productId);
	}
	
	public StockEntity addToStock(StockEntity stockEntity) {
		return stockRepository.save(stockEntity);
	}
	
	public List<StockEntity> getAllStock(){
		return (List<StockEntity>) stockRepository.findAll();
	}
	
	
	public List<StockEntity> getAllAvailableProducts(){
		return stockRepository.getAllAvailableProducts();
	}
	
	public List<StockEntity> getStockAvailableByProductId(String productId){
		return stockRepository.getStockAvailableByProductId(productId);
	}
	
	public List<StockEntity> getAllAvailableProductsByType(String type){
		return stockRepository.getAllAvailableProductsByType(type);
	}
	
	public List<StockEntity> getAllAvailableProductsByBrand(String brand){
		return stockRepository.getAllAvailableProductsByBrand(brand);
	}
	
	public int getCurrentStockByIds(String productId, String brand, int size) {
		if (stockRepository.getQuantityByIds(productId, brand, size) != null)
			return stockRepository.getQuantityByIds(productId, brand, size);
		else return 0;
	}
	
	public void updateStock(String productId, String brand, int size, int quantity) {
		stockRepository.updateStock(productId, brand, size, quantity);
	}
	
	public List<List<String>> getStockGroupedBy(){
		return stockRepository.getStockGroupedBy();
	}
}


