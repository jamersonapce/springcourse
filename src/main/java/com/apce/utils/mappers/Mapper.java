package com.apce.utils.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Mapper<T> {

	private final ModelMapper mapper = new ModelMapper();
	private T obj;

	@SuppressWarnings("unchecked")
	public <S> T toEntity(S dto) {
		this.configuration(dto.getClass());
		return (T) mapper.map(dto, obj.getClass());
	}

	private <S> void configuration(Class<S> dto) {
		Configuration builderConfiguration = mapper.getConfiguration().copy()
				.setDestinationNameTransformer(NameTransformers.builder())
				.setDestinationNamingConvention(NamingConventions.builder());
		mapper.createTypeMap(dto, obj.getClass(), builderConfiguration);
	}

}
