package com.apce.domains;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PAYMENT_SLIP")
@Getter
@NoArgsConstructor
public class PaymentSlip extends Payment {
	private static final long serialVersionUID = 1L;
	private LocalDate dueDate;
	private LocalDate payDate;
	
	@Builder
	public PaymentSlip(Integer id, String status, Order order, LocalDate dueDate, LocalDate payDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payDate = payDate;
	}
}
