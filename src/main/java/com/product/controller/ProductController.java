package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.ApiResponse;
import com.product.model.Product;
import com.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/greet")
	public String greet() {
		return "Services are up";
	}
	
	@PostMapping("/product")
	public ApiResponse saveProduct(@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return productService.fetchAll();
	}

	@PutMapping("/product")
	public ApiResponse updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product")
	public ApiResponse deleteProduct(@RequestBody Product product) {
		return productService.deleteProduct(product);
	}
	
	@GetMapping("/product/{productName}")
	public Product searchProduct(@PathVariable final String productName) {
		return productService.searchProduct(productName);
	}
	
}
