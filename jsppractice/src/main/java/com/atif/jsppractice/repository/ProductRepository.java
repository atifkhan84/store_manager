package com.atif.jsppractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atif.jsppractice.entity.ProductEntity;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
	
	@Query("SELECT p FROM ProductEntity p ORDER BY purchase_timestamp desc")
	public List<ProductEntity> getProductPurchaseInDescOrderByDate();
	
	@Query("SELECT p FROM ProductEntity p WHERE productId = :productId ORDER BY purchase_timestamp DESC, size LIMIT 1")
	public ProductEntity findProductByProductId(@Param("productId") String productId);
	
//	@Query(value="SELECT * FROM Product_purchase GROUP BY product_id", nativeQuery=true) This also works
	@Query("SELECT p FROM ProductEntity p GROUP BY p.productId")
	public List<ProductEntity> getAllProductDetails();
}
