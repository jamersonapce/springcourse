package com.apce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apce.domains.CategoryDomain;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDomain, Integer>{

}
