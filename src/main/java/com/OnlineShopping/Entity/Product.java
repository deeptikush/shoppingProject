package com.OnlineShopping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "product")
@Entity
@Data

	
public class Product {
	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long productId;
		
		@Column
		private String productName;
		
		@Column
		private String productDis;
		
		@Column
		private String date;

	}

