package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.Client;

@Repository
public interface PhoneRepository extends JpaRepository<Client, Integer>{

}
