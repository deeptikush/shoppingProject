package com.OnlineShopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineShopping.Service.CartService;
import com.OnlineShopping.ServiceImpl.CartServiceImpl;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping({"addtoCart/{productId}"})
	public void addCart(@PathVariable(name="productId") long productId)
	{
		
	}

}
