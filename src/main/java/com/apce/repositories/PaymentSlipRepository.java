package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.PaymentSlip;

@Repository
public interface PaymentSlipRepository extends JpaRepository<PaymentSlip, Integer>{

}
