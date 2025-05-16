package com.sdms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
public class TestController {

	@GetMapping("/get")
	public String get() {
		return "Ankur";
	}
}
