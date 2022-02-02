package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.User;
import com.proj.ovs.onlinevegetablesale.repos.UserRepo;
@Service
public class UserService {
@Autowired
UserRepo userRepo;
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user)  ;
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return  userRepo.findAll() ;
	}

	public boolean deleteAllUser() {
		// TODO Auto-generated method stub
		try {
			 userRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public User updateUser(int userId, User obj) {
		// TODO Auto-generated method stub
		Optional<User> userContainer=userRepo.findById(userId);
		 if(userContainer.isPresent())
		 {
			 User oldObj=userContainer.get();
			 oldObj.setPassword(obj.getPassword());
			 oldObj.setRole(obj.getRole());
			 System.out.println("successfully updated");
			 return userRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this user id");
		return obj;
	}

}
