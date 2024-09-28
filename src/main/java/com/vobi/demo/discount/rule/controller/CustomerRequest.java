package com.vobi.demo.discount.rule.controller;

import com.vobi.demo.discount.rule.model.Customer.Category;

import lombok.Data;

@Data
public class CustomerRequest {

	private Long customerId;
	private Category category = Category.NA;

}
