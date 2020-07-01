package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
