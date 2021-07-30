package com.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@Column(name="pid")
	private int pid;
	
	@NotEmpty(message="Product Name is mandatory")
	@Column(name="pname")
	private String pname;
	
	//@NotEmpty(message="Price is mandatory")
	@DecimalMax("100.0") 
	@DecimalMin("10.0")
	@Column(name="price")
	private Double price;
	
	@Column(name="man_date")
	private String manDate;
	
	@Column(name="exp_date")
	private String expDate;
		
}
