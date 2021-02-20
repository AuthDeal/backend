package com.laioffer.authdeal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @RequestMapping("/test")
  public String index() {
    return "Test from Spring Security Config!";
  }
}
