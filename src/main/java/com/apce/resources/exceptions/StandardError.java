package com.apce.resources.exceptions;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStamp;
}
