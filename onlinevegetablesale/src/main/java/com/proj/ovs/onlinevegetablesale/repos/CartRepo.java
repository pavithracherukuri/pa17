package com.proj.ovs.onlinevegetablesale.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proj.ovs.onlinevegetablesale.entity.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

}
