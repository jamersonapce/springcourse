package com.apce.utils.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Component;

import com.apce.domains.Category;
import com.apce.domains.dtos.CategoryDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CategoryMapper {

	private final ModelMapper mapper;

	public Category toCategory(CategoryDTO dto) {
		configuration(dto.getClass());
		Category c = mapper.map(dto, Category.CategoryBuilder.class).build();
		return c;
	}

	private  <T> void configuration(Class<T> entity) {
		Configuration builderConfiguration = mapper.getConfiguration().copy()
				.setDestinationNameTransformer(NameTransformers.builder())
				.setDestinationNamingConvention(NamingConventions.builder());
		mapper.createTypeMap(entity, Category.CategoryBuilder.class, builderConfiguration);
	}

}
