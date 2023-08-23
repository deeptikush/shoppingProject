package com.OnlineShopping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "address")
@Entity
@Data

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long addressId;

	@Column
	private long pinCode;

	@Column
	private String streetNo;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String buildingAddress;

	
	 @ManyToOne
	 @JoinColumn(name = "userId") 
	 User userinfo;


	
	

	 
}
