package com.OnlineShopping.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineShopping.Entity.Product;
import com.OnlineShopping.Repository.CartRepository;
import com.OnlineShopping.Repository.ProductRepository;
import com.OnlineShopping.Service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository  productRepository;
	
	@Override
	public void addToCart(long productId) {
		
		Product product=productRepository.findById(productId).get();
		
		if(product !=null)
		{
			
		}
	}

}
