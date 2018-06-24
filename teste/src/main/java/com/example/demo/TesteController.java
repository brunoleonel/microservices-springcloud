package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String teste() {
		return "teste";
	}
}
