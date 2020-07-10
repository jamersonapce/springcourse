package com.apce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.apce.domains.Category;
import com.apce.domains.dtos.categories.CategoryCreateDTO;
import com.apce.domains.dtos.categories.CategoryReadDTO;
import com.apce.domains.dtos.categories.CategoryUpdateDTO;
import com.apce.repositories.CategoryRepository;
import com.apce.services.exceptions.DataIntegrityException;
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

	@Override
	public void delete(Integer id) {
		this.find(id);
		try {
			this.repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("You cannot delete a category that has products!");
		}
	}

	@Override
	public List<CategoryReadDTO> findAll() {
		final List<CategoryReadDTO> resultList = this.repo.findAll().stream().map(obj -> 
			Mapper.<CategoryReadDTO.CategoryReadDTOBuilder>builder()
										.obj(CategoryReadDTO.builder())
										.build()
										.toDto(obj)
										.build()
		).collect(Collectors.toList());
		return resultList;
	}
}
