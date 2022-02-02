package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.repos.AddressRepo;
@Service
public class AddressService {
@Autowired
AddressRepo addressRepo;
	public Address createAddress(Address address) {
		return addressRepo.save(address);
	}

	public List<Address> getAddress() {
		return addressRepo.findAll();
	}

	public boolean deleteAllAddress( ) {
		 try {
			 addressRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}
	public Address updateAddress(int addressId, Address obj) {
		// TODO Auto-generated method stub
		 Optional<Address> addressContainer=addressRepo.findById(addressId);
		 if(addressContainer.isPresent())
		 {
			 Address oldObj=addressContainer.get();
			 oldObj.setFlatNo(obj.getFlatNo());
			 oldObj.setBuildingName(obj.getBuildingName());
			 oldObj.setArea(obj.getArea());
			 oldObj.setCity(obj.getCity());
			 oldObj.setState(obj.getState());
			 oldObj.setPincode(obj.getPincode());
			 System.out.println("successfully updated");
			 return addressRepo.saveAndFlush(oldObj);
		 }
		 else
		 {
		 System.out.println("No object found with this address id");
		return addressRepo.save(obj);
	}
	}

}
