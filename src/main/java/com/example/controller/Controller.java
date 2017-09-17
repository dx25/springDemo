package com.example.controller;

import com.example.annotation.Authenticate;
import com.example.bean.Message;
import com.example.bean.Person;
import com.example.service.MessageService;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by silence on 2017/7/4.
 */
@RestController
public class Controller {
    @Autowired
    PersonService personService;
    @Autowired
    MessageService messageService;

    @RequestMapping("/callAll")
    @Authenticate
    public List<Person> callAll() {
        return personService.callName();
    }

    @RequestMapping("/callSb/{id}")
    public Person callSb(@PathVariable("id") Long id) {
        return personService.callSb(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }

}
