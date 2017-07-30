package com.xebia.saml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class UiApplication {

  @RequestMapping("/resource")
  public Map<String, Object> home() {
    SecurityContext context = SecurityContextHolder.getContext();
    User principal = (User) context.getAuthentication().getPrincipal();
    Map<String, Object> model = new HashMap<>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello " + principal.getUsername());
    return model;
  }

  public static void main(String[] args) {
    SpringApplication.run(UiApplication.class, args);
  }

}
