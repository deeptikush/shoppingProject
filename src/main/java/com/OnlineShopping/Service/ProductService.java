package com.OnlineShopping.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.OnlineShopping.Entity.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	
	
	
	public Product getProduct();
	

}
