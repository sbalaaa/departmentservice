package com.training.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Value("${user}")
	private String  userName;

	
	@RequestMapping("/hello")
	@CrossOrigin(origins="*", maxAge = 3600)
	public String sayHello() {
		return "Hello Mr." + userName;
	}

}
