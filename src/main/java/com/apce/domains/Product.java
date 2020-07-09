package com.apce.domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Table(name = "TB_PRODUCT")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Digits(integer = 5, fraction = 2)
    private BigDecimal value;
	@Singular
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	@JsonIgnore
	@Singular
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items;
	
	@JsonIgnore
	public List<Order> getOrders(){
		List<Order> list = new ArrayList<>();
		for(OrderItem x : items) {
			list.add(x.getOrder());
		}
		return list;
	}
}
