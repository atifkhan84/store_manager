package com.atif.jsppractice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
//prodcut is only foowtare for my shop
public class Product {
	//later i will change product id to string with abbriviation of brand name eg. ADD001
	
	@jakarta.persistence.Id
	//doubt if "MySQL supports sequences directly or not."
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_sequence", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "prod_seq", strategy = GenerationType.SEQUENCE)
	private Integer id; //for mySql @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//later add validations
	private String productName;
	private String productBrandName;
	
	//give proper column name 
	private Float productMrp; //⚠️ Float is not precise for money (binary floating point leads to rounding errors).
//	or @DecimalMin(value = "0.0", inclusive = false)
//	private BigDecimal productMrp;

	//give proper column name eg. product_CP
	private Float productCostPrice;
	
	
	//should i add max-profit-margin possible or should i calculate from MRP- CP
	//✅ Best Practice: Don’t store something that can be calculated.
	//Instead, add a getter:
	/*
	 
	    @Transient // Not stored in DB
		public BigDecimal getProfitMargin() {
		    if (productMrp != null && productCostPrice != null) {
		        return productMrp.subtract(productCostPrice);
		    }
		    return BigDecimal.ZERO;
		}

	 
	 */
	
	
//	@Enumerated(EnumType.STRING) // Stores the enum name (e.g., "SNEAKERS") in the DB
	private ProductCategory productCategory;
    private String description;
    
    //is an enum
    private ShoeSize productShoeSize;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
	
}
