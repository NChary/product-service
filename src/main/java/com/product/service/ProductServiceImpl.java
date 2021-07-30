package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exceptions.ProductNotFoundException;
import com.product.model.ApiResponse;
import com.product.model.Product;
import com.product.repos.ProductRepository;
import com.product.util.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductUtil productUtil;

	private final String SUCCESS_CODE = "000";

	private final String FAILURE_CODE = "999";

	@Override
	public ApiResponse saveProduct(Product product) {
		if(product.getPrice()!=null) {
			//Save data into database
			productRepository.save(product); // If you dont have pk value then insert it as a new record
			return productUtil.buildApiResponse(SUCCESS_CODE, "Product Saved Successfully");
		}else {
			return productUtil.buildApiResponse(FAILURE_CODE, "Product price is mandatory");
		}
	}

	@Override
	public List<Product> fetchAll() {
		return productRepository.findAll();
	}

	@Override
	public ApiResponse updateProduct(Product product) {
		productRepository.save(product);  // If you have pk value then it will update
		return productUtil.buildApiResponse(SUCCESS_CODE, "Product Updated Successfully");
	}

	@Override
	public ApiResponse deleteProduct(Product product) {
		productRepository.delete(product);
		return productUtil.buildApiResponse(SUCCESS_CODE, "Product Deleted Successfully");
	}

	@Override
	public Product searchProduct(String productName) {
		Optional<Product> optProduct = productRepository.findByPname(productName);

		Product product = null;

		if(optProduct.isPresent()) {
			product = optProduct.get();
		}else {
			throw new ProductNotFoundException("Product is not found");
		}
		return product;
	}

}
