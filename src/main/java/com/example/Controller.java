package com.example;

import com.example.bean.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by silence on 2017/7/4.
 */
@RestController
public class Controller {
    @Autowired
    PersonService personService;

    @RequestMapping("/callAll")
    public List<Person> callAll(){
        return personService.callName();
    }

    @RequestMapping("/callSb/{id}")
    public Person callSb(@PathVariable("id") Long id){
        return personService.callSb(id);
    }

}
