package com.application.library.controllers;

import com.dummyframework.annotations.Controller;
import com.dummyframework.annotations.RequestMapping;
import com.dummyframework.annotations.ResponseBody;
import com.dummyframework.utils.RequestMethod;

@Controller
public class NewController {

  @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/plain")
  @ResponseBody
  public String add() {
    return "Hello World!";
  }

}
