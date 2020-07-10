package com.apce.domains.dtos.categories;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class CategoryUpdateDTO implements CategoryDTO, Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "The name is Required")
	@Length(min = 5, max = 80, message = "The length must be between 5 and 80 characters")
	private String name;
}
