package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.models.Item;
import com.example.demo.models.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class Integration {

	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CartClient cartClient;
	
	@HystrixCommand(fallbackMethod = "unavailableUser")
	public User getUser(int id) {
		return userClient.getUser(id);
	}
	
	@HystrixCommand(fallbackMethod = "unavailableItems")
	public List<Item> getItems(int id) {
		return cartClient.getItems(id);
	}
	
	public User unavailableUser(int id) {
		return null;
	}
	
	public List<Item> unavailableItems(int id) {
		return null;
	}
}
