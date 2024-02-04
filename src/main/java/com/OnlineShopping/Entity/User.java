package com.OnlineShopping.Entity;



import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import com.OnlineShopping.Enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
import jakarta.persistence.Table;

import lombok.Data;


@Table(name = "users")
@Entity
@Data

public class User {

	private UUID uuid =  UUID.randomUUID();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@OneToMany(mappedBy ="userinfo" ,cascade = CascadeType.REMOVE)
	  	private List<Address> address ;
	
	
	
	 //@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	@Column(name="user_phone",unique =true)
	private long userPhone;
  	//@Email(message="Enter valid Email Id.")
	@Column(name="user_email",unique =true, nullable=false)
	private String userEmail;
	
	@Column(name = "password")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Column(name="gender")
	private String gender;
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@Column(name ="created date")
	private String date;
	
	
	@Column(name ="active")
	private boolean active; 
	
	
	public String getPassword(){
	   return password;
	}


	public void setPassword(String encryptedPassword) {
		this.password=encryptedPassword;
		
	}


	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", userId=" + userId + ", userName=" + userName + ", address=" + address
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", password=" + password + ", gender="
				+ gender + ", userType=" + userType + ", date=" + date + ", active=" + active + "]";
	}
	
	
	

}
