package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;

@Service
public class PoductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).orElseThrow(()-> new IDNotFoundException("no id present pls provide valid id"));
	}

}
