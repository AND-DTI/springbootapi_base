package com.and.apibase.controller;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.system.ApplicationHome;
//import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;

//import io.swagger.v3.oas.annotations.Hidden;


//@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class HomeController {
  
  @GetMapping("/") 
  public String home() {
      //return "redirect:/swagger-ui/index.html";
      //if (ENV = "----"){ };
      
      return "redirect:/swagger-ui.html";
      //return "http://localhost:3000";
  }

}