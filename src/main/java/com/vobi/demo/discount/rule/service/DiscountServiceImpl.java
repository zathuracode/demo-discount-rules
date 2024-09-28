package com.vobi.demo.discount.rule.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.vobi.demo.discount.rule.controller.CustomerRequest;
import com.vobi.demo.discount.rule.controller.DiscountResponse;
import com.vobi.demo.discount.rule.model.Customer;
import com.vobi.demo.discount.rule.model.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {
	
	private KieContainer kieContainer;

	public DiscountServiceImpl(KieContainer kieContainer) {
		super();
		this.kieContainer = kieContainer;
	}
	
	@Override
	public DiscountResponse applyDiscount(CustomerRequest customerRequest) {
		
		KieSession kieSession = kieContainer.newKieSession();

		Customer customer=new Customer();
		customer.setCustomerId(customerRequest.getCustomerId());
		customer.setCategory(customerRequest.getCategory());

		Order order = new Order();
		order.setCustomer(customer);

		kieSession.insert(customer);
		kieSession.insert(order);

		int fired = kieSession.fireAllRules();
		
    	kieSession.dispose();

		log.info("Fired:" + fired);
		log.info("Discount:" + order.getDiscount().getPercentage());
		
		DiscountResponse discountResponse=new DiscountResponse(order.getDiscount().getPercentage());
		
		return discountResponse;
	}

}