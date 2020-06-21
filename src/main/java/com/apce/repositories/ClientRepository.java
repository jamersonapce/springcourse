package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.Phone;

@Repository
public interface ClientRepository extends JpaRepository<Phone, Integer>{

}
