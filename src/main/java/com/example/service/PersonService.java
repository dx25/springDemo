package com.example.service;

import com.example.bean.Person;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dingxy on 2017/5/8.
 */
@Service
public class PersonService {

    @Autowired
    private UserMapper userMapper;

    public List<Person> callName() {
        List<Person> list = userMapper.getAll();
        for (Person p : list) {
            System.out.println(p);
        }
        return list;
    }

    public Person callSb(Long id) {
        Person p = userMapper.selectPersonByPK(id);
        System.out.println(p);
        return p;
    }

    public boolean verifyToken(String token){
        //TODO add redis
        return token.equals("123456");
    }
}
