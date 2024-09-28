package com.vobi.demo.discount.rule.service;

import com.vobi.demo.discount.rule.controller.CustomerRequest;
import com.vobi.demo.discount.rule.controller.DiscountResponse;

public interface DiscountService {

	DiscountResponse applyDiscount(CustomerRequest customerRequest);

}