package com.apce.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerType {

	PHYSICALPERSON(1, "Physical person"), LEGALPERSON(2, "Legal person");

	private int cod;
	private String description;

	public static CustomerType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (CustomerType x : CustomerType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + cod);
	}

}
