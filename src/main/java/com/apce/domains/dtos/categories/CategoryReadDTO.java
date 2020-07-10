package com.apce.domains.dtos.categories;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryReadDTO implements CategoryDTO, Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
}
