package com.apce.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PAYMENT_CARD")
@Getter
@NoArgsConstructor
public class PaymentCard extends Payment {
	private static final long serialVersionUID = 1L;
	private Integer installment;
	
	@Builder
	public PaymentCard(Integer id, String status, Order order, Integer installment) {
		super(id, status, order);
		this.installment = installment;
	}
}
