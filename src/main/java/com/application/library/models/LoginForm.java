package com.application.library.models;

public class LoginForm {

  String name;
  String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "LoginForm [name=" + name + ", password=" + password + "]";
  }
}
