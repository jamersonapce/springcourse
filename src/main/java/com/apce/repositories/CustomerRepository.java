package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
