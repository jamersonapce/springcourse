package com.apce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apce.domains.Category;
import com.apce.domains.dtos.CategoryCreateDTO;
import com.apce.domains.dtos.CategoryUpdateDTO;
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
	public Category insert(CategoryCreateDTO dto) {
		Category entity = Mapper.<Category.CategoryBuilder>builder()
								.obj(Category.builder())
									.build()
										.toEntity(dto)
											.id(null)
												.build();
		return this.repo.save(entity);
	}

	@Override
	public Category update(Integer id, CategoryUpdateDTO dto) {
		this.find(id);
		Category entity = Mapper.<Category.CategoryBuilder>builder()
								.obj(Category.builder())
									.build()
										.toEntity(dto)
											.id(id)
												.build();
		return this.repo.save(entity);
	}
}
