package com.OnlineShopping.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineShopping.Entity.Product;
import com.OnlineShopping.Repository.ProductRepository;
import com.OnlineShopping.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		
		productRepository.save(product);
		
		
	}

	
		
	
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
