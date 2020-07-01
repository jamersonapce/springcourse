package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.PaymentCard;

@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard, Integer>{

}