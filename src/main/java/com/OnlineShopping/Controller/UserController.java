package com.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineShopping.Entity.Address;
import com.OnlineShopping.Entity.User;
import com.OnlineShopping.Repository.RoleRepository;
import com.OnlineShopping.Service.AddressService;
import com.OnlineShopping.Service.UserService;
import com.OnlineShopping.Entity.Role;




@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserService userService;
	@Autowired
	AddressService addressService;

	@PostMapping("/addUser")
	public String registerUser(@RequestBody User user) {

		return userService.addUser(user);
	}
	/*
	 * public void initRoleAndUser() { Role adminRole= new Role();
	 * adminRole.setRoleName("admin"); adminRole.setRoleDescirption("admin role");
	 * roleRepository.save(adminRole); Role userRole= new Role();
	 * userRole.setRoleName("user"); userRole.setRoleDescirption("user role");
	 * roleRepository.save(userRole);
	 * 
	 * }
	 */

	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(value = "pageNumber", required = false) int pageNumber,
			@RequestParam(value = "pageSize", required = false) int pageSize) {

		return userService.fetchUsers(pageNumber, pageSize);

	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {

		User user= userService.getUser(id);

		return user; 
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUserById(id);

	}

	@PostMapping("/userAddress")
	public void addUserAddress(@RequestBody Address address) {

		addressService.addAddress(address);

	}
	
	@PostMapping("/authenticateUser")
	public String authenticateUser(@RequestParam(value = "userEmailId", required = false) String userEmailId,
			@RequestParam(value = "password", required = false) String password)
	{
		return userService.authenticateUser(userEmailId,password);
		
	}
//	public String authenticateUser(@RequestParam(value = "userEmailId", required = false) String userEmailId,
//			@RequestParam(value = "password", required = false) String password)

}
