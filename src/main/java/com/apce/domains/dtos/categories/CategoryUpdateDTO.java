package com.apce.domains.dtos.categories;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryUpdateDTO implements CategoryDTO, Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
}
