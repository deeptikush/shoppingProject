package com.OnlineShopping.ServiceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.OnlineShopping.Entity.User;
import com.OnlineShopping.Repository.UserRepository;
import com.OnlineShopping.Service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@Service
public class UserServiceImpl implements UserService {

	private  final  EntityManager entityManager;
	@Autowired
	UserRepository userRepository;
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
	
	public UserServiceImpl(EntityManager entityManager)
	{
		this.entityManager= entityManager;
	}

	@Override
	public String addUser(User user) {

	
		String encryptedPassword=bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		LocalDateTime currentDateTime = LocalDateTime.now();  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	     user.setDate(currentDateTime.format(formatter));
	 
	
		
//         user.setDate(formatter.format(currentDateTime).toString()); 
		
		
		userRepository.save(user);
		return "user added";

	}

	@Override
	public List<User> fetchUsers(int pageNumber, int pageSize) {
		
		int offSet= pageNumber*pageSize;
		String sql="Select * from users LIMIT :pageSize OFFSET :offset";
		
	
		
	 @SuppressWarnings("unchecked")
	List<User> usersList= entityManager.createNativeQuery(sql, User.class)
				.setParameter("pageSize", pageSize)
				.setParameter("offset", offSet)
				.getResultList();
	 
	 return usersList;
				
				
		
		/* List<YourEntity> resultList = entityManager.createNativeQuery(sql, YourEntity.class)
	                .setParameter("pageSize", pageSize)
	                .setParameter("offset", offset)
	                .getResultList();

	        return resultList;
	    }*/
	
		
				///query(sql, new Object[] {pageSize, offSet}, yourEntityRowMapper);
				
				//return jdbcTemplate.query(sql, new Object[]{pageSize, offset}, yourEntityRowMapper);
		  
		
		//org.springframework.data.domain.Pageable page = PageRequest.of(pageNumber, pageSize);
			//Page<User> pageUsers = userRepository.findAll(page);
		//List<User> users = pageUsers.getContent();
				//return users
						
	}
	
	

	@Override
	public User getUser(long id) {
		Optional<User> user= userRepository.findById(id);
		
		
		return user.get();
	}

	@Override
	@Transactional
	public String deleteUserById(long id) {

		// EntityTransaction transaction = entityManager.getTransaction();
		if (!userRepository.findById(id).isEmpty()) {
			System.out.println("return \"user found\";" + userRepository.findById(id));
			String sql = "Delete from users where user_id =:id";
			int flag = entityManager.createNativeQuery(sql).setParameter("id", id).executeUpdate();

			if (flag == 1) {
				return "deleted user sucessfully";
			} else {
				return "user not deleted ";
			}
		} else {

			return "user not found";

		}

	}
	
	public String authenticateUser( String userEmailId ,String password) {

		User opUser = userRepository.userfindByEmail(userEmailId);
		if (opUser != null) {
			User dbUser = opUser;
			
			if(bcrypt.matches(password, dbUser.getPassword()))
			
				return "user is authenticated";

			else

				return "user is not authenticated";
	}

		// throw userNotFoundException("no user not found for this user email id")
		return "unknown email id";
	}

	
}
