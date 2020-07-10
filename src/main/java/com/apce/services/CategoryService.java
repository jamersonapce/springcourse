package com.apce.services;

import java.util.List;

import com.apce.domains.Category;
import com.apce.domains.dtos.categories.CategoryCreateDTO;
import com.apce.domains.dtos.categories.CategoryReadDTO;
import com.apce.domains.dtos.categories.CategoryUpdateDTO;

public interface CategoryService {

	public Category find(Integer id);
	public Category insert(CategoryCreateDTO dto);
	public Category update(Integer id, CategoryUpdateDTO dto);
	public void delete(Integer id);
	public List<CategoryReadDTO> findAll();
}
