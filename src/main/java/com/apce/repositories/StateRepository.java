package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
