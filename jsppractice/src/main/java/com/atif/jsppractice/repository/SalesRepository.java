package com.atif.jsppractice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atif.jsppractice.entity.SalesEntity;

@Repository
public interface SalesRepository extends CrudRepository<SalesEntity, Integer> {
	
//	@Query(value="SELECT * FROM Sales s WHERE date(sales_timestamp) = :date", nativeQuery=true)
//	Both the query works
	
	@Query("SELECT s FROM SalesEntity s WHERE date(salestimestamp) = :date")
	public List<SalesEntity> getSalesBasedOnDate(@Param("date") Date date);
}
