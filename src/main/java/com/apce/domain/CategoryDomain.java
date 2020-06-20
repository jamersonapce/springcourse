package com.apce.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString(exclude = "id")
@EqualsAndHashCode(of = "id")
public class CategoryDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
}
