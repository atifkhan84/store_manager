package com.atif.jsppractice.repository;
import com.atif.jsppractice.entity.Stock;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atif.jsppractice.entity.StockEntity;

@Repository
public interface StockRepository extends CrudRepository<StockEntity, Stock>{
	
//	@Query("SELECT s FROM StockEntity s ORDER BY stockTimestamp")
//	public List<StockEntity> findAll();
	
	@Query(value="SELECT * FROM Stock WHERE quantity>0", nativeQuery=true)
	public List<StockEntity> getAllAvailableProducts();
	
	@Query(value="select * from stock where instr(description, lower(:type))", nativeQuery = true)
	public List<StockEntity> getAllAvailableProductsByType(@Param("type") String type);
	
	@Query(value="select * from stock where instr(concat(brand,product_id), lower(:brand))", nativeQuery = true)
	public List<StockEntity> getAllAvailableProductsByBrand(@Param("brand") String brand);
	
	public List<StockEntity> findByProductId(String productId);
	
	@Query("SELECT s FROM StockEntity s WHERE s.quantity>0 AND s.productId =:productId")
	public List<StockEntity> getStockAvailableByProductId(@Param("productId") String productId);
	
	@Query("SELECT se.quantity FROM StockEntity se WHERE se.productId = :productId and se.brand = :brand and se.size =:size")
	public Integer getQuantityByIds(@Param("productId") String productId, @Param("brand") String brand, @Param("size") int size);
	
	@Query("UPDATE StockEntity se SET se.quantity = :quantity WHERE se.productId = :productId and se.brand=:brand and se.size =:size")
	public void updateStock(@Param("productId") String productId, @Param("brand") String brand, @Param("size") int size, @Param("quantity") int quantity);
	
	@Query(value="SELECT product_id, brand, group_concat(size, ':', quantity) FROM stock GROUP BY product_id, brand ORDER BY sum(quantity) DESC", nativeQuery=true)
	public List<List<String>> getStockGroupedBy();
}
