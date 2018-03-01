package com.example.service;

import com.example.bean.Classmates;
import com.example.bean.ClassmatesExample;
import com.example.exception.InvalidArgumentException;
import com.example.mapper.ClassmatesMapper;
import com.example.vm.ClassmatesListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by dingxy on 2018/3/1.
 */
@Service
public class ClassmatesService {
  @Autowired
  private ClassmatesMapper classmatesMapper;

  /**
   * 插入或修改，有id是修改，无id是插入
   *
   * @param classmates
   */
  public void addClassmate(Classmates classmates) {
    if (classmates == null || StringUtils.isEmpty(classmates.getName())) {
      throw new
          InvalidArgumentException();
    }
    if (classmates.getId() == null || classmates.getId() == 0L) {
      //mybatis 中insert返回的是插入的条数
      classmatesMapper.insert(classmates);
    } else {
      classmatesMapper.updateByPrimaryKeySelective(classmates);
    }
  }

  public List<Classmates> listClassmates(ClassmatesListRequest request) {
    //加了查询条件再改这
    List<Classmates> result = classmatesMapper.selectByExample(new ClassmatesExample());
    return result;
  }

}
