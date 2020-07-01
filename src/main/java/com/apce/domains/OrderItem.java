package com.apce.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ORDER_ITEM")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private OrderItemPK id;
	@Digits(integer = 5, fraction = 2)
	private BigDecimal discount;
	@Digits(integer = 5, fraction = 2)
	private BigDecimal value;
	private Integer amount;

	@Builder
	public OrderItem(Order order, Product product, @Digits(integer = 5, fraction = 2) BigDecimal discount,
			@Digits(integer = 5, fraction = 2) BigDecimal value, Integer amount) {
		super();
		this.id = OrderItemPK.builder().order(order).product(product).build();
		this.discount = discount;
		this.value = value;
		this.amount = amount;
	}

	public Order getOrder() {
		return id.getOrder();
	}

	public Product getProduct() {
		return id.getProduct();
	}

}
