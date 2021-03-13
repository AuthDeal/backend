package com.laioffer.authdeal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
  @RequestMapping("/test")
  public String index() {
    return "Test from Spring Security Config!";
  }
}
