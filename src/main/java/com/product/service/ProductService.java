package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {
	
	String saveProduct(Product product);
	
	List<Product> fetchAll();
	
	String updateProduct(Product product);
	
	String deleteProduct(Product product);
}
