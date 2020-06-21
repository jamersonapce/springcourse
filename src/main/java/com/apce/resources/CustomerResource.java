package com.apce.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apce.domains.Customer;
import com.apce.services.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	private final CustomerService serv;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Customer obj = this.serv.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
