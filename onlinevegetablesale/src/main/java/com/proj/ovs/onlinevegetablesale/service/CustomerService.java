package com.proj.ovs.onlinevegetablesale.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.Customer;
import com.proj.ovs.onlinevegetablesale.exception.AddressNotFoundException;
import com.proj.ovs.onlinevegetablesale.repos.AddressRepo;
import com.proj.ovs.onlinevegetablesale.repos.CustomerRepo;
@Service
public class CustomerService {
@Autowired
CustomerRepo customerRepo;
@Autowired
AddressRepo addressRepo;

	public Customer createCustomer(Customer customer) {
		Address address=customer.getAddress();
		int addressId=address.getAddressId();
		if(addressId>0)
		{
			Optional<Address> addressContainer = addressRepo.findById(addressId);
			if(addressContainer.isPresent())
			{
				customer.setAddress(addressContainer.get());
			}
			else {
				throw new AddressNotFoundException("Address is not found");
			}
		}
			return  customerRepo.save(customer);
	
		}



	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}

	public boolean deleteAllCustomer( ) {
		 try {
			 customerRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
		
	}

	public Customer updateCustomer(int customerId, Customer obj) {
		// TODO Auto-generated method stub
		Optional<Customer> customerContainer=customerRepo.findById(customerId);
		 if(customerContainer.isPresent())
		 {
			 Customer oldObj=customerContainer.get();
			 oldObj.setName(obj.getName());
			 oldObj.setMobileNumber(obj.getMobileNumber());
			 oldObj.setAddress(obj.getAddress());
			 oldObj.setEmailId(obj.getEmailId());
			 oldObj.setPassword(obj.getPassword());
			 oldObj.setConfirmPassword(obj.getConfirmPassword());
			 System.out.println("successfully updated");
			 return customerRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this customer id");
		return obj;
	}
	
}