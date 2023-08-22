package com.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineShopping.Entity.User;
import com.OnlineShopping.ServiceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/addUser")
	public String registerUser(@RequestBody User user) {
		if (user != null) {
			userServiceImpl.addUser(user);
			return "add user";
		}
		return "no dtata";
	}

	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(value="pageNumber",required = false) int pageNumber,
			@RequestParam(value="pageSize",required = false) int pageSize) {

		
		return userServiceImpl.fetchUsers(pageNumber,pageSize);

	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {

		return userServiceImpl.getUser(id);

	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable long id)
	{
		return userServiceImpl.deleteUserById(id);
		
	}

}
