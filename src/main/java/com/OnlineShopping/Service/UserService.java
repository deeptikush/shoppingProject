package com.OnlineShopping.Service;

import java.util.List;



import com.OnlineShopping.Entity.User;

public interface UserService {
	
	public String addUser(User user);
	public List<User> fetchUsers(int pageNumber, int pageSize);
	public User  getUser(long id);
	public String deleteUserById(long id);
	public String authenticateUser(String userEmailId ,String password);
	
}
