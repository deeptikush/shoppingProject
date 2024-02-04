package com.OnlineShopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineShopping.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
