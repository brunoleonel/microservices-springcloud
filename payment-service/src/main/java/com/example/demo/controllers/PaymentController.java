package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Configs;
import com.example.demo.models.Item;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;

@RestController
public class PaymentController {

	@Autowired
	private Configs config;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(path = "/pay/{transactionId}", method = RequestMethod.PUT)
	public Transaction pay(@PathVariable String transactionId) {
		
		Transaction transaction = new Transaction();
		transaction.setId(transactionId);
		transaction.setCurrency(config.getCurrency());
		transaction.setUser(this.getUser());
		transaction.setItems(this.getItems());
		
		return transaction;
	}
	
	private User getUser() {
		
		List<ServiceInstance> instances = client.getInstances("user-service");
		if (!instances.isEmpty()) {
			URI uri = instances.get(0).getUri();
			URI resource = URI.create(String.format("%s/%s/%s", uri.toString(), "user", "1"));
			if (resource != null) {
				return new RestTemplate().getForObject(resource, User.class);
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private List<Item> getItems() {
		
		List<ServiceInstance> instances = client.getInstances("cart-service");
		if (!instances.isEmpty()) {
			URI uri = instances.get(0).getUri();
			URI resource = URI.create(String.format("%s/%s/%s", uri.toString(), "cart", "1"));
			if (resource != null) {
				return new RestTemplate().getForObject(resource, List.class);
			}
		}
		return null;
	}
}
