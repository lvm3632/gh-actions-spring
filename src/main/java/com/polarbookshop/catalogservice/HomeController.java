package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.config.PolarProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ConditionalOnProperty(name = "polar.testdata.enabled", havingValue = "true")
public class HomeController {

	private final PolarProperties polarProperties;

	public HomeController(PolarProperties polarProperties) {
		this.polarProperties = polarProperties;
	}

	@GetMapping("/")
	public String getGreeting() {
		return polarProperties.getGreeting();
	}

}
