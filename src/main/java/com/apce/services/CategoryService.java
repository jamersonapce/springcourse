package com.apce.services;

import com.apce.domains.Category;
import com.apce.domains.dtos.CategoryCreateDTO;
import com.apce.domains.dtos.CategoryUpdateDTO;

public interface CategoryService {

	public Category find(Integer id);
	public Category insert(CategoryCreateDTO dto);
	public Category update(Integer id, CategoryUpdateDTO dto);
	public void delete(Integer id);
}
