package com.OnlineShopping.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineShopping.Entity.Address;
import com.OnlineShopping.Repository.AddressRepository;
import com.OnlineShopping.Service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired AddressRepository addressRepository;

	@Override
	public String addAddress(Address address) {
		if(address!=null) {
		addressRepository.save(address);
		return "address added";
		}
		return "address not added ";
	}

	@Override
	public List<Address> getUserAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
