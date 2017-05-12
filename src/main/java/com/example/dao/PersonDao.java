package com.example.dao;

import com.example.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingxy on 2017/5/8.
 */
public class PersonDao {
  public List<Person> getPersonList(){
    ArrayList<Person> arrayList = new ArrayList<>();
    Person p = new Person();
    p.setName("xiaoming");
    p.setGender("male");
    arrayList.add(p);
    return arrayList;
  }
}
