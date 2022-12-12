package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.InvalidPasswordException;
import com.axis.model.Customer;
import com.axis.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer add(Customer customer) {
		String passwordLength = customer.getPassword();
		
		if (passwordLength.length()<4) {
			throw new InvalidPasswordException( "pasword length must be greater than 4");
		}
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllProducts() {
		return customerRepository.findAll();
	}
	
	

}
