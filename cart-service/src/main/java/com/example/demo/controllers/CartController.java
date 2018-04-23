package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Item;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public List<Item> getItems(String id) {
		
		List<Item> items = new ArrayList<Item>();
		
		for (int i = 0; i < 3; i++) {
			Item item = new Item();
			item.setDescription(String.format("Produto %s", String.valueOf(i)));
			item.setAmount(1);
			item.setPrice(10.50f);
			items.add(item);
		}
		
		return items;
	}
}
