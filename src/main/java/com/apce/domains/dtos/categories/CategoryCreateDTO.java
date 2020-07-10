package com.apce.domains.dtos.categories;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryCreateDTO implements CategoryDTO, Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
}
