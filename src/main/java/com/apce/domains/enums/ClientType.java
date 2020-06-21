package com.apce.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientType {

	PHYSICALPERSON(1, "Physical person"), LEGALPERSON(2, "Legal person");

	private int cod;
	private String description;

	public static ClientType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (ClientType x : ClientType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + cod);
	}

}
