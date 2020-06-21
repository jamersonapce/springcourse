package com.apce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apce.domains.Category;
import com.apce.repositories.CategoryRepository;
import com.apce.services.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repo;

	@Override
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Category not found!") );
	}
	
	private Category convertDTOToEntity() {
		return null;
	}
}
