package com.apce.services;

import com.apce.domains.Category;
import com.apce.domains.dtos.CategoryDTO;

public interface CategoryService {

	public Category find(Integer id);
	public Category insert(CategoryDTO obj);
}
