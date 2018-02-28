package com.example;

import com.example.service.PersonService;
import com.example.service.TokenService;
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
  @Autowired
  private TokenService tokenService_;
  private static PersonService personService;
  private static TokenService tokenService;

  @PostConstruct
  public void init() {
    personService = personService_;
    tokenService = tokenService_;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringDemoApplication.class, args);
    personService.callName();
    personService.callSb(2l);
    //System.out.println(tokenService.generateToken(123));
    //tokenService.invalidToken("21b068d0a00b469b8e85aa41f94737b6");
    System.out.println(tokenService.getUserIdByToken("280e513ed44048c280e221c849848699"));
  }

}
