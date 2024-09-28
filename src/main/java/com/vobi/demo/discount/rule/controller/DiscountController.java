package com.vobi.demo.discount.rule.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.demo.discount.rule.service.DiscountService;

@RestController
@RequestMapping("/api/v1/discount")
class DiscountController {
	
	DiscountService discountService;
		
	public DiscountController(DiscountService discountService) {
		super();
		this.discountService = discountService;
	}

	@PostMapping
	DiscountResponse applyDiscount(@RequestBody CustomerRequest customerRequest) {
		return discountService.applyDiscount(customerRequest);
	}

}
