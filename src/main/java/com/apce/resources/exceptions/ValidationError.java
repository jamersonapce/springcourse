package com.apce.resources.exceptions;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	@Singular
	private List<FieldMessage> errors;
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
}
