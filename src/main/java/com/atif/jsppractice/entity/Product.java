package com.atif.jsppractice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
//prodcut is only foowtare for my shop
//later add validations
//later i will change product id to string with abbriviation of brand name eg. ADD001
public class Product {
	
	@Id
	@SequenceGenerator(name = "prod_seq", sequenceName = "PROD_SEQ_01", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "prod_seq", strategy = GenerationType.SEQUENCE)
	private Integer id; //for mySql @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "PRODUCT_NAME", length = 100, nullable = false)
	@NotBlank(message = "Product name cannot be blank")
	private String productName;
	
	@Column(name = "PRODUCT_BRAND_NAME", length = 50, nullable = false)
	@NotBlank(message = "Product brand name cannot be blank")
	private String productBrandName;
	
	@Column(name = "PRODUCT_MRP", nullable = false, precision = 10, scale = 2)
	private Float productMrp; //⚠️ Float is not precise for money (binary floating point leads to rounding errors).
//	or @DecimalMin(value = "0.0", inclusive = false)
//	private BigDecimal productMrp;

	//give proper column name eg. product_CP
	@Column(name = "PRODUCT_CP", nullable = false, precision = 10, scale = 2)
	private Float productCP;
	
	
	@Transient//doubt about which package to use spring or jakarta
	@Column(name = "PRODUCT_PROFIT_MARGIN", nullable = false, precision = 10, scale = 2)
	private Float productProfitMargin = this.productMrp - this.productCP;
	
	
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
