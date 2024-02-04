package com.OnlineShopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineShopping.Entity.Role;
import com.OnlineShopping.ServiceImpl.RoleServiceImpl;



@RestController
@RequestMapping("/role")
public class RoleController {

	
	@Autowired
	RoleServiceImpl roleServiceImpl;

	@PostMapping({ "createNewRole" })
	public Role createNewRole(@RequestBody Role role) {
		return roleServiceImpl.createNewRole(role);

	}
	
}
