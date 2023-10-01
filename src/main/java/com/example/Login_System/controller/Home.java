package com.example.Login_System.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j

@Controller
public class Home {
  @GetMapping("/")
    public String home()
    {
        log.info("Inside Index Controller Page");
        return "index";
    }
}
