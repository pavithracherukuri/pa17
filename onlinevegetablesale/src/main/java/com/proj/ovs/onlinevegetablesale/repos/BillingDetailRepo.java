package com.proj.ovs.onlinevegetablesale.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proj.ovs.onlinevegetablesale.entity.BillingDetail;
@Repository
public interface BillingDetailRepo extends JpaRepository<BillingDetail,Integer> {

}
