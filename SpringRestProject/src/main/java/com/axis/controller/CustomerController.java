package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Customer;
import com.axis.service.CustomerService;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addProduct(@RequestBody Customer customer)
	{
		Customer customer1 = customerService.add(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Customer>> getAllProducts(){
		return null;
	}
	

}
