package com.proj.ovs.onlinevegetablesale.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.FeedBack;
import com.proj.ovs.onlinevegetablesale.repos.FeedBackRepo;
@Service
public class FeedBackService {
@Autowired
FeedBackRepo feedBackRepo;
	public FeedBack createFeedBack(FeedBack feedBack) {
		// TODO Auto-generated method stub
		return feedBackRepo.save(feedBack);
	}

	public List<FeedBack> getfeedBack() {
		// TODO Auto-generated method stub
		return  feedBackRepo.findAll();
	}

	public boolean deleteAllFeedBack() {
		// TODO Auto-generated method stub
		try {
			feedBackRepo.deleteAll();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
		 return true;
	}

	public FeedBack updateFeedBack(int feedbackId, FeedBack obj) {
		// TODO Auto-generated method stub
		Optional<FeedBack> feedBackContainer=feedBackRepo.findById(feedbackId);
		 if(feedBackContainer.isPresent())
		 {
			 FeedBack oldObj=feedBackContainer.get();
			 oldObj.setVegetableId(obj.getVegetableId());
			 oldObj.setRating(obj.getRating());
			 oldObj.setComments(obj.getComments());
			 System.out.println("successfully updated");
			 return feedBackRepo.saveAndFlush(oldObj);
		 }
		 System.out.println("No object found with this feedback id");
		return obj;
	}
	}

