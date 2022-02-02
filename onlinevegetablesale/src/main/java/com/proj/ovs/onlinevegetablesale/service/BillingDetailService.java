package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.ctrl.BillingDetailController;
import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.BillingDetail;
import com.proj.ovs.onlinevegetablesale.entity.Customer;
import com.proj.ovs.onlinevegetablesale.exception.AddressNotFoundException;
import com.proj.ovs.onlinevegetablesale.repos.AddressRepo;
import com.proj.ovs.onlinevegetablesale.repos.BillingDetailRepo;
@Service
public class BillingDetailService {
@Autowired
BillingDetailRepo billingdetailRepo;
@Autowired
AddressRepo addressRepo;
public BillingDetail createBillingDetails(BillingDetail billingDetail) {
	
	Address address=billingDetail.getBillingAddress();
	int addressId=address.getAddressId();
	if(addressId>0)
	{
		Optional<Address> addressContainer= addressRepo.findById(addressId);
		if(addressContainer.isPresent())
		{
			billingDetail.setBillingAddress(addressContainer.get());
		}
		else {
			throw new AddressNotFoundException("Address is not found");
		}
	}
	
	return  billingdetailRepo.save(billingDetail);
}

	public java.util.List<BillingDetail> getBillingDetail() {
		// TODO Auto-generated method stub
		return billingdetailRepo.findAll(); 
	}

	public boolean deleteAllBillingDetail() {
		// TODO Auto-generated method stub
		 try {
			 billingdetailRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public BillingDetail updateBillingDetail(int billingId, BillingDetail obj) {
		// TODO Auto-generated method stub
		 Optional<BillingDetail> billingdetailContainer=billingdetailRepo.findById(billingId);
		 if(billingdetailContainer.isPresent())
		 {
			 BillingDetail oldObj=billingdetailContainer.get();
			 oldObj.setOrderId(obj.getOrderId());
			 oldObj.setTransactionMode(obj.getTransactionMode());
			 oldObj.setTransactionStatus(obj.getTransactionStatus());
			 oldObj.setBillingAddress(obj.getBillingAddress());
			 System.out.println("successfully updated");
			 return billingdetailRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this billing id");
		return obj;
	}
	}


