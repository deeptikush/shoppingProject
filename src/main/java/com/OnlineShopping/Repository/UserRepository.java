package com.OnlineShopping.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OnlineShopping.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="Select * from users u where u.user_email = :userEmail",nativeQuery = true)
	
	public User userfindByEmail(String userEmail);
	
	@Query (value="Select *  from users  u INNER JOIN address a where a.user_id= :userId",nativeQuery = true)
	public User findByUserId(long userId);
	
	

}
