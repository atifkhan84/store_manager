package com.atif.jsppractice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atif.jsppractice.entity.SalesEntity;
import com.atif.jsppractice.repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	public SalesEntity sell(SalesEntity salesEntity) {
		return salesRepository.save(salesEntity);
	}
	
	public List<SalesEntity> getAllProductsSold() {
		return (List<SalesEntity>) salesRepository.findAll();
	}
	
	public List<SalesEntity> getSalesBasedOnDate(Date date){
		return salesRepository.getSalesBasedOnDate(date);
	}
}
