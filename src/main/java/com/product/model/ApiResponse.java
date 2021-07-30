package com.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ApiResponse {
	
	private String code;
	private String message;
	
}
