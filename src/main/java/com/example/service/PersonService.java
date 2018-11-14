package com.example.service;

import com.example.bean.Person;
import com.example.mapper.UserMapper;
import com.example.util.EncryUtil;
import com.example.util.JWTUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dingxy on 2017/5/8.
 */
@Service
public class PersonService {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private TokenService tokenService;

  //在application.properties里
  @Value("${app.salt}")
  private String appSalt;

  //在application.properties里
  @Value("${app.secret}")
  private String appSecret;

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

  public boolean verifyToken(String token) {
    //long userId = tokenService.getUserIdByToken(token);
    String userName = JWTUtil.getUsername(token);
    return JWTUtil.verify(token, userName, appSecret);
  }

  public String genPassword(String password) {
    String passHash = DigestUtils.md5Hex(appSalt + password);
    String encry = EncryUtil.encrypt(passHash, appSecret);
    return encry;
  }

  public Person login(Person person) throws Exception {
    if (person.getName() != null && person.getPassword() != null) {
      Person result = userMapper.selectPersonByUserName(person.getName());
      if (result.getPassword().equals(genPassword(person.getPassword()))) {
        //                String token = tokenService.generateToken(result.getId());
        String token = JWTUtil.sign(person.getName(), appSecret);
        result.setToken(token);
        return result;
      } else {
        throw new Exception();
      }
    } else {
      throw new Exception();
    }
  }

  public void updatePassword(Person person) {
    userMapper.updatePassword(person);
  }
}
