package com.apce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apce.domains.Category;
import com.apce.domains.Category.CategoryBuilder;
import com.apce.domains.dtos.CategoryDTO;
import com.apce.repositories.CategoryRepository;
import com.apce.services.exceptions.ObjectNotFoundException;
import com.apce.utils.mappers.Mapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repo;

	@Override
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Category not found!"));
	}

	@Override
	public Category insert(CategoryDTO dto) {
		Mapper<CategoryBuilder> mapper = Mapper.<Category.CategoryBuilder>builder()
												.obj(Category.builder().id(null))
												.build();
		Category entity = mapper.toEntity(dto).build();
		return this.repo.save(entity);
	}
}
