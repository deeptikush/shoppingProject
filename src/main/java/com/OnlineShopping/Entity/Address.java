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
	@Column(name="address_id")
	private long addressId;

	@Column(name="pin_code")
	private long pinCode;

	@Column(name="street_no")
	private String streetNo;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="building_address")
	private String buildingAddress;

	
	@Column(name="contact_no")
	private long contactNo;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id") 
	 private User userinfo;

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", pinCode=" + pinCode + ", streetNo=" + streetNo + ", city=" + city
				+ ", state=" + state + ", buildingAddress=" + buildingAddress + ", contactNo=" + contactNo
				+ ", userinfo=" + userinfo + "]";
	}


	
	

	 
}
