package com.OnlineShopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineShopping.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
