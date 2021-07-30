package com.product.service;

import java.util.List;

import com.product.model.ApiResponse;
import com.product.model.Product;

public interface ProductService {
	
	ApiResponse saveProduct(Product product);
	
	List<Product> fetchAll();
	
	ApiResponse updateProduct(Product product);
	
	ApiResponse deleteProduct(Product product);
	
	Product searchProduct(String productName);
}
