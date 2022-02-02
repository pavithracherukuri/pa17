package com.proj.ovs.onlinevegetablesale.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proj.ovs.onlinevegetablesale.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{

}
