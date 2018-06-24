package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Item;

@FeignClient(name = "cart-service")
public interface CartClient {

	@RequestMapping(value = "/cart/{cartId}", method = RequestMethod.GET)
	List<Item> getItems(@PathVariable("cartId") int cartId); 
}
