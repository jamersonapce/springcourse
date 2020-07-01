package com.apce.domains;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PAYMENT_SLIP")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class PaymentSlip implements Payment, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String status;
	private LocalDate dueDate;
	private LocalDate payDate;
	@OneToOne
	@JoinColumn(name = "order_id")
	@MapsId
	private Order order;
}
