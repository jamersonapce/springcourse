package com.apce.domains;

import java.io.Serializable;

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
@Table(name = "TB_PAYMENT_CARD")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class PaymentCard implements Payment, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String status;
	private Integer installment;
	@OneToOne
	@JoinColumn(name = "order_id")
	@MapsId
	private Order order;
	
}
