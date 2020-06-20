package com.apce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apce.domains.CategoryDomain;
import com.apce.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;

	@Override
	public CategoryDomain find(Integer id) {
		Optional<CategoryDomain> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	private CategoryDomain convertDTOToEntity() {
		return null;
	}
}
