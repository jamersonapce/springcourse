package com.apce.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatus {

	PENDENT(1, "Pendent"), SETTLED(2, "Settled"), CANCELED(2, "Canceled");

	private int cod;
	private String description;

	public static PaymentStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PaymentStatus x : PaymentStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + cod);
	}

}
