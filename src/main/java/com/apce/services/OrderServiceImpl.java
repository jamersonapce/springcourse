package com.apce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apce.domains.Order;
import com.apce.repositories.OrderRepository;
import com.apce.services.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repo;

	@Override
	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Order not found!") );
	}
	
	private Order convertDTOToEntity() {
		return null;
	}
}
