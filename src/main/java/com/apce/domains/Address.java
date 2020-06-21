package com.apce.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String streetAddress;
	private String number;
	private String neighborhood;
	private String zipCode;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
