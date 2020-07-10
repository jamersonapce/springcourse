package com.apce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apce.domains.Customer;
import com.apce.repositories.CustomerRepository;
import com.apce.services.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repo;

	@Override
	public Customer find(Integer id) {
		Optional<Customer> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Customer not found!") );
	}
	
}
