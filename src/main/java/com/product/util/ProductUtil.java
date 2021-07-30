package com.product.util;

import org.springframework.stereotype.Component;

import com.product.model.ApiResponse;

@Component
public class ProductUtil {

	public ApiResponse buildApiResponse(String code, String message) {
		
		return ApiResponse.builder()
				.code(code)
				.message(message)
				.build();
		
	}
	
}
