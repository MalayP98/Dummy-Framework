package com.application.library.config;

import com.dummyframework.annotations.Primary;
import com.dummyframework.annotations.Service;

@Service
public class InterfcBImpl implements InterfcA {

  @Override
  public void disp() {
    System.out.println("\n\nfrom " + this.getClass().getName() + " \n\n");

  }

}
