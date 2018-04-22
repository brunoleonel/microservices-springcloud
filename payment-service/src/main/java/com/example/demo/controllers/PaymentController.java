package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Configs;

@RestController
public class PaymentController {

	@Autowired
	private Configs config;
	
	@RequestMapping(path = "/config", method = RequestMethod.GET)
	public Configs getLang() {
		return this.config;
	}
}
