package com.OnlineShopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.OnlineShopping.Entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{

}
