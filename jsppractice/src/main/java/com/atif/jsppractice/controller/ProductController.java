package com.atif.jsppractice.controller;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atif.jsppractice.bean.BulkProductBean;
import com.atif.jsppractice.bean.Prac;
import com.atif.jsppractice.entity.ProductEntity;
import com.atif.jsppractice.entity.SalesEntity;
import com.atif.jsppractice.entity.StockEntity;
import com.atif.jsppractice.service.ProductService;
import com.atif.jsppractice.service.SalesService;
import com.atif.jsppractice.service.StockService;

import jakarta.validation.Valid;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private StockService stockService;
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/")
	public String home() {
		return "Home";
	}
//	--------------------PRACTICE-------------------------------------------------------------------------------------------------------
	@GetMapping("/hii")
	public String hello(@RequestParam(value = "name", defaultValue = "World", required = true) String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@GetMapping("/practice")
	public ModelAndView thisd() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("practice");
		Prac prac = new Prac();
		Map<String, String> country = new HashMap<String, String>();
		country.put("India", "good");
		country.put("USA", "bad");
		prac.setMaps(country);

		modelAndView.addObject("pra", prac);
		modelAndView.addObject("sizes", new ArrayList<Integer>());
		
		return modelAndView;
	}
	@PostMapping("/practice")
	public void doThis(@ModelAttribute("pra") Prac prac) {
	}

//	------------------PRACTICE END---------------------------------------------------------------------------------------------------------

	
	@GetMapping("/productsPurchased")
	public ModelAndView getAllProducts(){
		List<ProductEntity> list = productService.getProductPurchaseInDescOrderByDate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("allProducts");
		modelAndView.addObject("productList", list);
		return modelAndView;
	}
	
	@GetMapping("/sales")
	public ModelAndView getAllProductsSold(){
		List<SalesEntity> list = salesService.getAllProductsSold();
		Collections.reverse(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Sales");
		modelAndView.addObject("salesList", list);
		return modelAndView;
	}
	
	@GetMapping("salesBasedOnDate")
	public ModelAndView getSalesBasedOnDate(Date date){
		List<SalesEntity> salesList = salesService.getSalesBasedOnDate(date);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Sales");
		modelAndView.addObject("salesList", salesList);
		
		return modelAndView;
	}
	
	@GetMapping("/sellProduct")
	public ModelAndView sellProductPage(){

		ModelAndView modelAndView = new ModelAndView();
		
		//To populate the form with predefined values
		List<StockEntity> listOfProductsAvailableInStock = stockService.getAllAvailableProducts();
		Collections.reverse(listOfProductsAvailableInStock);	
		
		Map<String, String> productIdAndBrand = new HashMap<String, String>();
		Set<String> brandList = new HashSet<String>();
		Set<String> description = new HashSet<String>();
		
		if(listOfProductsAvailableInStock != null) {
		for (int i=0; i<listOfProductsAvailableInStock.size(); i++) {
			productIdAndBrand.put(listOfProductsAvailableInStock.get(i).getProductId(), listOfProductsAvailableInStock.get(i).getBrand());
			brandList.add(listOfProductsAvailableInStock.get(i).getBrand());
			description.add(listOfProductsAvailableInStock.get(i).getDescription());
		}
		}

		modelAndView.addObject("productIdList", productIdAndBrand);
		modelAndView.addObject("brandList", brandList);
		modelAndView.addObject("descriptionList", description);

		
		modelAndView.setViewName("SellProductPage");
//		modelAndView.addObject("productsAvailable", listOfProductsAvailableInStock);
		modelAndView.addObject("productDetailExist", true);
		
		modelAndView.addObject("salesEntity", new SalesEntity());
		return modelAndView;
	}
	@PostMapping("/getDetails")
	public ModelAndView getDetails(String productId) {
		
		List<StockEntity> productsInStock = stockService.getStockAvailableByProductId(productId);
		
		ProductEntity productEntity = productService.getProductByProductId(productId);
		
		Boolean productDetailExist = true;
		
		if (productEntity == null) productDetailExist = false;

		
		ModelAndView modelAndView = sellProductPage();
		modelAndView.setViewName("SellProductPage");
		
		modelAndView.addObject("productDetails", productEntity);
		modelAndView.addObject("productDetailExist", productDetailExist);
		modelAndView.addObject("productInStockBasedOnProductId", productsInStock);
		return modelAndView;
	}
	
	@PostMapping("/sellProduct")
	public ModelAndView sellProduct(@Valid @ModelAttribute("salesEntity") SalesEntity salesEntity){
		
		salesService.sell(salesEntity);
		
		String productId = salesEntity.getProductId();
		String brand = salesEntity.getBrand();
		String description = salesEntity.getDescription();
		int size = salesEntity.getSize();
		int quantitySold = salesEntity.getQuantity();
		
// Get current stock information------There are three ids for the stock entity
		int openingQuantity = stockService.getCurrentStockByIds(productId, brand, size);
		
		
		StockEntity stockEntity = new StockEntity();
		
		
		stockEntity.setProductId(productId);
		stockEntity.setBrand(brand);
		stockEntity.setDescription(description);
		stockEntity.setSize(size);
		stockEntity.setQuantity(openingQuantity-quantitySold);
		stockEntity.setStockTimestamp(new Timestamp(System.currentTimeMillis()));
		
		stockService.addToStock(stockEntity);
		
		ModelAndView modelAndView = sellProductPage();
		modelAndView.setViewName("SellProductPage");
		modelAndView.addObject("success", true);
		return modelAndView;
	}
	
	@GetMapping("/purchaseProduct")
	public ModelAndView purchaseProductPage() {
		
		//To fill the form
		List<ProductEntity> list = productService.getAllProductDetails();
		Set<String> brandList = new HashSet<String>();
		Set<String> descriptionList = new HashSet<String>();
		Set<Float> discountList = new HashSet<Float>();
		
		for (int i=0; i<list.size(); i++) {	
			brandList.add(list.get(i).getBrand());
			descriptionList.add(list.get(i).getDescription());
			discountList.add(list.get(i).getDiscount());
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseProductPage");
		modelAndView.addObject("bulkProductEntity", new BulkProductBean());
		
		
		modelAndView.addObject("brandList", brandList);
		modelAndView.addObject("descriptionList", descriptionList);
		modelAndView.addObject("discountList", discountList);
		modelAndView.addObject("productList", list);
		return modelAndView;
	}
	
	@PostMapping("/getDetailsForPurchase")
	public ModelAndView getDetailsForPurchase(String productId) {
		
		ProductEntity productEntity = productService.getProductByProductId(productId);
		Boolean productExist = true;
		if(productEntity == null) {
			productExist = false;
		}
		
		ModelAndView modelAndView = purchaseProductPage();
		modelAndView.setViewName("PurchaseProductPage");
		
		modelAndView.addObject("productDetails", productEntity);
		modelAndView.addObject("productExists", productExist);
		return modelAndView;
	}
	
	
	@PostMapping("/purchaseProduct")
	public ModelAndView purchaseProduct(@Valid @ModelAttribute("bulkProductEntity") BulkProductBean bulkProductEntity){
		
		
		for (int i = 0; i<bulkProductEntity.getSize().size(); i++) {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(bulkProductEntity.getProductId());
			productEntity.setBrand(bulkProductEntity.getBrand());
			productEntity.setMrp(bulkProductEntity.getMrp());
			productEntity.setDiscount(bulkProductEntity.getDiscount());
			productEntity.setDescription(bulkProductEntity.getDescription());
			productEntity.setSupplierId(bulkProductEntity.getSupplierId());
			productEntity.setPayment_status(bulkProductEntity.getPaymentStatus());
			
			productEntity.setSize(bulkProductEntity.getSize().get(i));
			productEntity.setQuantity(bulkProductEntity.getQuantity().get(i));
			
			productService.addProductPurchase(productEntity);
			
			int openingQuantity = stockService.getCurrentStockByIds(productEntity.getProductId(), productEntity.getBrand()
					, productEntity.getSize());
			
			StockEntity stockEntity = new StockEntity();
			
			stockEntity.setProductId(productEntity.getProductId());
			stockEntity.setBrand(productEntity.getBrand());
			stockEntity.setDescription(productEntity.getDescription());
			stockEntity.setSize(productEntity.getSize());
			stockEntity.setQuantity(productEntity.getQuantity()+openingQuantity);
			stockEntity.setStockTimestamp(new Timestamp(System.currentTimeMillis()));
			
			stockService.addToStock(stockEntity);
		}
		
		ModelAndView modelAndView = purchaseProductPage();
		modelAndView.addObject("success", true);
		modelAndView.setViewName("PurchaseProductPage");
		return modelAndView;
	}
	
	
	@GetMapping("/stockStatus")
	public ModelAndView getAllStock(){
		List<StockEntity> list = stockService.getAllStock();
		Collections.reverse(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStocks");
		modelAndView.addObject("stockList", list);
		return modelAndView;
	}
	
	@GetMapping("/newStockView")
	public ModelAndView getStock() {
		List<List<String>> list = stockService.getStockGroupedBy();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("NewStockView");
		modelAndView.addObject("list",list);
		return modelAndView;
	}
	
	@GetMapping("/stockBasedOn")
	public ModelAndView getAllStockBasedOnType(@RequestParam(value="type") String type){
		
		List<StockEntity> list = stockService.getAllAvailableProductsByType(type);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStocks");
		modelAndView.addObject("stockList", list);
		return modelAndView;
	}
	@GetMapping("/stockBasedOnBrand")
	public ModelAndView getAllStockBasedOnBrand(@RequestParam(value="brand") String brand){
		
		List<StockEntity> list = stockService.getAllAvailableProductsByBrand(brand);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AllStocks");
		modelAndView.addObject("stockList", list);
		return modelAndView;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleValidationExceptions(Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", ex.getMessage());
		modelAndView.addObject("exception", ex);
		modelAndView.setViewName("GeneralizedExceptionPage");
	    return modelAndView;
	}
}