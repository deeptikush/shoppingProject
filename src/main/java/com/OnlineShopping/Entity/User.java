package com.OnlineShopping.Entity;


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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
   	private Address address ;
	
	@Column
	private long userPhone;
	@Column
	private String userEmail;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	
	
	public void setAddress(Address address)
	{
		this.address=address;
		
	}

}
