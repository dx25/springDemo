package service;

import bean.Person;
import dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dingxy on 2017/5/8.
 */
@Service
public class PersonService {
  @Autowired
  private PersonDao personDao;

  public void callName() {
    List<Person> list = personDao.getPersonList();
    for (Person p : list) {
      System.out.println(p);
    }
  }
}
