package com.getdrugs.getdrugs.drugs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrugsController {
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
