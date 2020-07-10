package com.apce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		final List<CategoryReadDTO> resultList = this.repo.findAll().stream().map(item -> 
			Mapper.<CategoryReadDTO.CategoryReadDTOBuilder>builder()
										.obj(CategoryReadDTO.builder())
										.build()
										.toDto(item)
										.build()
		).collect(Collectors.toList());
		return resultList;
	}

	@Override
	public Page<CategoryReadDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		final Page<CategoryReadDTO> resultList = this.repo.findAll(pageRequest).map(item -> 
					Mapper.<CategoryReadDTO.CategoryReadDTOBuilder>builder()
												.obj(CategoryReadDTO.builder())
												.build()
												.toDto(item)
												.build()
		);
		return resultList;
	}
}
