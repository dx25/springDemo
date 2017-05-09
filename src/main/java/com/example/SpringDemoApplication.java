package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.PersonService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringDemoApplication {
//	@Autowired
//	private  PersonService personService_;
//
//	static PersonService personService;
//
//	@PostConstruct
//	public void init(){
//		personService = personService_;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
		//personService.callName();
	}

}
