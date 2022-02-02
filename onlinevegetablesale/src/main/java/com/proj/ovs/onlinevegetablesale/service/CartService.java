package com.proj.ovs.onlinevegetablesale.service;

import java.util.ArrayList;
import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.Cart;
import com.proj.ovs.onlinevegetablesale.entity.Customer;
import com.proj.ovs.onlinevegetablesale.entity.Vegetable;
import com.proj.ovs.onlinevegetablesale.exception.CustomerNotFoundException;
import com.proj.ovs.onlinevegetablesale.exception.VegetableIdNotFoundException;
import com.proj.ovs.onlinevegetablesale.exception.VegetableListEmptyException;
import com.proj.ovs.onlinevegetablesale.repos.CartRepo;
import com.proj.ovs.onlinevegetablesale.repos.CustomerRepo;
import com.proj.ovs.onlinevegetablesale.repos.VegetableRepo;
@Service
public class CartService {
@Autowired
CartRepo cartRepo;
@Autowired
VegetableRepo  vegetableRepo;
@Autowired
CustomerRepo customerRepo;
public Cart createCart(Cart cart) {
	List<Vegetable>  vegetableList =cart.getVegetable();
	if(vegetableList.size()>0)
	{
		List<Vegetable> newVegetableList= new ArrayList<>();
		for(int i=0;i<vegetableList.size();i++)
		{
			Optional<Vegetable> vegetableContainer = vegetableRepo.findById(vegetableList.get(i).getVegId());
			if(!(vegetableContainer.isPresent()))
			{
				throw new VegetableIdNotFoundException("vegetableId is not found");
			}
			else {
				newVegetableList.add(vegetableContainer.get());
			}
		}
		cart.setVegetable(newVegetableList);
	}
	else {
		throw new VegetableListEmptyException("Vegetable List is Empty");
	}
	
	Customer  customer =cart.getCustomer();
	int customerId=customer.getCustomerId();
	if(customerId>0)
	{
		Optional<Customer> customerContainer = customerRepo.findById(customerId);
		if(customerContainer.isPresent())
		{
			cart.setCustomer(customerContainer.get());
		}
		else {
			throw new CustomerNotFoundException("customer is not found");
		}
	}
	return cartRepo.save(cart);
}


	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	public boolean deleteAllCart() {
		// TODO Auto-generated method stub
		 try {
			 cartRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public Cart updateCart(int cartId, Cart obj) {
		// TODO Auto-generated method stub
		Optional<Cart> cartContainer=cartRepo.findById(cartId);
		 if(cartContainer.isPresent())
		 {
			 Cart oldObj=cartContainer.get();
			 oldObj.setVegetable(obj.getVegetable());
			 System.out.println("successfully updated");
			 return cartRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this cart id");
		return obj;
	}

}
