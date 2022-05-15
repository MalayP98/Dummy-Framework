package com.application.library.config;

import com.dummyframework.annotations.Autowired;
import com.dummyframework.annotations.BeanName;
import com.dummyframework.annotations.Service;

@Service
public class AService {

  @Autowired
  @BeanName(name = "abc")
  Model model;


  public AService() {
    System.out.println("\n *** Service Class created *** \n");
  }

  @Autowired
  public void fun(InterfcA interfcA) {
    interfcA.disp();
  }

}
