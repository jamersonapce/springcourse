package com.apce.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Table(name = "TB_CUSTOMER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private String customerType;
	@Singular
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Address> addresses;
	@Singular
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Phone> phones;
}
