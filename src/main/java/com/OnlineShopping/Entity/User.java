package com.OnlineShopping.Entity;


import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import com.OnlineShopping.Enums.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.Data;


@Table(name = "users")
@Entity
@Data

public class User {

	private UUID uuid =  UUID.randomUUID();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column
	private String userName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
   	private Set<Address> address ;
	
	@Column
	 @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	private long userPhone;
	@Column
	@Email(message="Enter valid Email Id.")
	private String userEmail;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	
	
	

}
