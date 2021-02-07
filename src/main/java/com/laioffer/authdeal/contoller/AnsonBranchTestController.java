package com.laioffer.authdeal.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnsonBranchTestController {
  @RequestMapping("/ansonbranch")
  public String index() {
    return "Anson Branch Test from Spring Security Config!";
  }
}
