package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String saveProduct(Product product) {
		//Save data into database
		productRepository.save(product); // If you dont have pk value then insert it as a new record
		return "Product Saved Successfully";
	}

	@Override
	public List<Product> fetchAll() {
		return productRepository.findAll();
	}

	@Override
	public String updateProduct(Product product) {
		productRepository.save(product);  // If you have pk value then it will update
		return "Product Updated Successfully";
	}

	@Override
	public String deleteProduct(Product product) {
		productRepository.delete(product);
		return "Product Deleted Successfully";
	}

}
