package com.example;

import com.example.service.PersonService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.example.mapper")
public class SpringDemoApplication {
	@Autowired
	private PersonService personService_;

	private static PersonService personService;

	@PostConstruct
	public void init(){
		personService = personService_;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
		personService.callName();
		personService.callSb(2l);
	}

}
