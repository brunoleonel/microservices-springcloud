package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Integration;
import com.example.demo.models.Configs;
import com.example.demo.models.Item;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;

@RestController
@RefreshScope
public class PaymentController {

	@Value("${default-tax.brl}")
	private float brl;
	
	@Value("${default-tax.usd}")
	private float usd;
	
	@Autowired
	private Configs config;
	
	@Autowired
	private Integration integration;
	
	@RequestMapping(path = "/pay/{transactionId}", method = RequestMethod.GET)
	public Transaction pay(@PathVariable String transactionId) {
		
		Transaction transaction = new Transaction();
		transaction.setId(transactionId);
		transaction.setCurrency(config.getCurrency());
		transaction.setUser(this.getUser());
		transaction.setItems(this.getItems());
		transaction.setTaxBRL(brl);
		transaction.setTaxUSD(usd);
		
		return transaction;
	}
	
	private User getUser() {
		
		return integration.getUser(1);
	}
	
	private List<Item> getItems() {
		
		return integration.getItems(1);
	}
}
