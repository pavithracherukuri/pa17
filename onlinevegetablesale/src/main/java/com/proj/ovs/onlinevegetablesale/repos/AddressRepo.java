package com.proj.ovs.onlinevegetablesale.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.ovs.onlinevegetablesale.entity.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {



}

