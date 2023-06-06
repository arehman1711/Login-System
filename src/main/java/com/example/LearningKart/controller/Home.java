package com.example.LearningKart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j

@Controller
public class Home {
  @GetMapping("/Home")
    public String Home(Model model)
    {
        log.info("Inside Index Controller Page");
        return "index";
    }
}
