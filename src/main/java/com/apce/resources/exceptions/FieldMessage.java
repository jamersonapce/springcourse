package com.apce.resources.exceptions;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String message;
}
