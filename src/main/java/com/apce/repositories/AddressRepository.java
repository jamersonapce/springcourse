package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
