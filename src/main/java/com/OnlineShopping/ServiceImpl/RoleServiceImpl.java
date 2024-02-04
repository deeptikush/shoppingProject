package com.OnlineShopping.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineShopping.Entity.Role;
import com.OnlineShopping.Repository.RoleRepository;
import com.OnlineShopping.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  
  RoleRepository roleRepository;
  
	public Role createNewRole(Role role) {
		roleRepository.save(role);
		return role;
	}
	

}
