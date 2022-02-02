package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.Admin;
import com.proj.ovs.onlinevegetablesale.repos.AdminRepo;
@Service
public class AdminService {
@Autowired
   AdminRepo adminRepo;
	public Admin  createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	public List<Admin> getAdmins( ) {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	public boolean deleteAllAdmin() {
		// TODO Auto-generated method stub
		 try {
			 adminRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public Admin updateAdmin(int adminId, Admin obj) {
		// TODO Auto-generated method stub
		Optional<Admin> adminContainer=adminRepo.findById(adminId);
		 if(adminContainer.isPresent())
		 {
			 Admin oldObj=adminContainer.get();
			 oldObj.setName(obj.getName());
			 oldObj.setContactNumber(obj.getContactNumber());
			 oldObj.setEmailId(obj.getEmailId());
			 System.out.println("successfully updated");
			 return adminRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this admin id");
		return obj;
	}
}
