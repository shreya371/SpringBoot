package com.axis.service;

import java.util.List;

import com.axis.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
}
