package com.example.bean;

/**
 * Created by dingxy on 2017/5/8.
 */
public class Person {
  private String name;
  private String gender;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        '}';
  }
}
