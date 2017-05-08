package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.PersonService;

@SpringBootApplication
public class SpringDemoApplication {
	@Autowired
	private static PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
		personService.callName();
	}

}
