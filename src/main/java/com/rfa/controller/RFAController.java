package com.rfa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RFAController {

	@GetMapping(value = "/")
	public String home() {
		return "Welcome to RSS Feeds Aggregator!";
	}
}
