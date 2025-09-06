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
	/*
	
	Your method `getStockByProductId` has a few issues. Here's a corrected and improved version of the code, followed by an explanation:

---

### ✅ **Corrected Java Code**

```java
public StockEntity getStockByProductId(String productId) {
    return stockRepository.findById(Integer.parseInt(productId))
            .orElseThrow(() -> new RuntimeException("Bad Product_ID: " + productId));
}
```

---

### 🔍 **Issues in Your Original Code**

1. ❌ **Missing `return` statement**
   Your method doesn't return anything, even though its return type is `StockEntity`.

2. ❌ **Incorrect method name `orThrow`**
   Java's `Optional` class does not have a method called `orThrow()`. The correct method is `orElseThrow()`.

3. ❌ **Incorrect exception instantiation**
   You wrote `RuntimeException("Bad Product_ID")` without the `new` keyword.

4. ⚠️ **Risk of `NumberFormatException`**
   `Integer.parseInt(productId)` will throw a `NumberFormatException` if the input is not a valid integer. You might want to handle that.

---

### 🛡️ **Optional: More Robust Version with Error Handling**

```java
public StockEntity getStockByProductId(String productId) {
    try {
        int id = Integer.parseInt(productId);
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found for productId: " + productId));
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid productId format: " + productId, e);
    }
}
```


	
	
	*/
	
}


