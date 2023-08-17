package com.OnlineShopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OnlineShopping.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@Query("select p from Product p where p.productName IS NOT NULL")
	public List<Product> getAllProductQuery();

}
