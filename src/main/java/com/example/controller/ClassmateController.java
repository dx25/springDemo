package com.example.controller;

import com.example.bean.Classmates;
import com.example.service.ClassmatesService;
import com.example.vm.ClassmatesListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dingxy on 2018/3/1.
 */
@RestController
@RequestMapping("/classmates")
public class ClassmateController {

  @Autowired
  private ClassmatesService classmatesService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public void addClassmate(@RequestBody Classmates classmates) {
    classmatesService.addClassmate(classmates);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public List<Classmates> listClassmates(@RequestBody ClassmatesListRequest request) {
    List<Classmates> list = classmatesService.listClassmates(request);
    return list;
  }
}
