package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.service.PersonService;

/**
 * Created by silence on 2017/5/9.
 */
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private PersonService personService;
    @Override
    public void run(String... strings) throws Exception {
        personService.callName();
    }
}
