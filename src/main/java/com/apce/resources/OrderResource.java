package com.apce.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apce.domains.Order;
import com.apce.services.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	private final OrderService serv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> find(@PathVariable Integer id) {
		Order obj = this.serv.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
