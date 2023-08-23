package com.OnlineShopping.Service;

import java.util.List;

import com.OnlineShopping.Entity.Address;

public interface AddressService {
	
	public String addAddress(Address address);
	
	public List<Address> getUserAddress(); 
	
	public Address  updateAddress(long id);

}
