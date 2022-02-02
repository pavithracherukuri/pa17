package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.Order;
import com.proj.ovs.onlinevegetablesale.repos.OrderRepo;
@Service
public class OrderService {
@Autowired
OrderRepo orderRepo;
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return  orderRepo.save(order)  ;
	}

	public List<Order> getOrder() {
		// TODO Auto-generated method stub
		return  orderRepo.findAll() ;
	}

	public boolean deleteAllOrder( ) {
		// TODO Auto-generated method stub
		try {
			 orderRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public Order updateOrder(int customerId, Order obj) {
		// TODO Auto-generated method stub
		Optional<Order> orderContainer=orderRepo.findById(customerId);
		 if(orderContainer.isPresent())
		 {
			 Order oldObj=orderContainer.get();
			 oldObj.setTotalAmount(obj.getTotalAmount());
			 oldObj.setStatus(obj.getStatus());
			 System.out.println("successfully updated");
			 return orderRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this order id");
		return obj;
	}

		
	}

