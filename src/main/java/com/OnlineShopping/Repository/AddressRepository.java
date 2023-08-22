package com.OnlineShopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineShopping.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
