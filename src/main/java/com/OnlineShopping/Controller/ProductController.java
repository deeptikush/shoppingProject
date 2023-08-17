package com.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineShopping.Entity.Product;
import com.OnlineShopping.Repository.ProductRepository;
import com.OnlineShopping.ServiceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired 
	
	ProductRepository productRepository;
	
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product)
	{
		productServiceImpl.addProduct(product);
		
		return product.getProductDis()+"..."+product.getProductName()+".."+product.getProductId()+"..."+product.getDate();
	}

	@GetMapping("/allProduct")
	public List<Product> allProduct()
	{
		return productRepository.getAllProductQuery();
		
	}
	
}