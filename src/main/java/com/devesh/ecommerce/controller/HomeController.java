package com.devesh.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
      @GetMapping("/")
    public String home() {
        return "Ecommerce Backend Running Successfully";
    }
@GetMapping("/about")
     public String about() {
        return "Ecommerce about Running Successfully";
    }


    
}
