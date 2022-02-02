package com.proj.ovs.onlinevegetablesale.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proj.ovs.onlinevegetablesale.entity.FeedBack;
@Repository
public interface FeedBackRepo extends JpaRepository <FeedBack,Integer>{

}
