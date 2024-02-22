package com.cbfacademy;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(title = "API Assessment", version = "0.0.1", description = "Demo project for Spring Boot"), servers = @Server(url = "/", description = "Default Server URL"))

public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public-apis")
				.packagesToScan("com.cbfacademy") // Adjust the package to scan for your APIs)
				.build();
	}

}

// Main method to start Spring Boot application
// Controller: Classes handling HTTP requests (e.g., REST controllers)
// Model: Classes representing entities or data models (e.g., User, FoodItem).
// Service: Classes containing business logic.
// Repository: Classes for database interactions.
// Config: Classes for configuration settings.