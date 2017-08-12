package com.xebia.saml;

import com.xebia.saml.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class UiApplication {

  @RequestMapping("/resource")
  public Map<String, Object> home() {
    SecurityContext context = SecurityContextHolder.getContext();
    User principal = (User) context.getAuthentication().getPrincipal();
    Map<String, Object> model = new HashMap<>();
    model.put("username", principal.getUsername());
    model.put("email", principal.getEmail());
    model.put("givenName", principal.getGivenName());
    model.put("familyName", principal.getFamilyName());

    return model;
  }

  public static void main(String[] args) {
    SpringApplication.run(UiApplication.class, args);
  }

}
