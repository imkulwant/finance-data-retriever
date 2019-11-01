package com.rfa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RFAController {

	@GetMapping(value = "/")
	public String defaultHome() {
		return "Welcome to RSS Feeds Aggregator!";
	}

	@GetMapping(value = "/user")
	public String userHome() {
		return "<h1>Welcome User</h1>";
	}

	@GetMapping(value = "/admin")
	public String adminHome() {
		return "<h1>Welcome Admin</h1>";
	}
}
