package com.axis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.axis.model.Customer;

public interface CustomerService {
	
	public Customer add(Customer customer);
	public List<Customer> getAllProducts();

}
