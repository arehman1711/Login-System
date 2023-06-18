package com.example.LearningKart.controller;

import com.example.LearningKart.entities.User;
import com.example.LearningKart.service.interfaces.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Controller
public class login {
    @Autowired
    private UserService userService;
    @GetMapping("/Home")
    public String Home(Model model) {
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/login")
    public String login()
    {
        log.info("Inside the Login Page");
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("success", "Logged out successfully.");
        log.info("Logged out successfully.");
        return "index";
    }

    @RequestMapping(value = "/do_login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, @ModelAttribute("user") User user, Model model) {

        log.info("USER : " + user);
        boolean isValidUser = userService.isValidUser(user);

        if(isValidUser){
            log.info("Session User :  " + user);
            model.addAttribute("user ", user);
            session.setAttribute("user", user);
            session.setAttribute("name", user.getName());
            model.addAttribute("success", "Login successfully.");
            model.addAttribute("info", "Welcome "+ user.getName() + "!");
            log.info("Welcome "+ user.getName() + "!");
            return "index";
        }
        log.info("Invalid email/password.");
        model.addAttribute("error", "Invalid email/password.");
        return "login";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(HttpSession session, @ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {

        log.info("USER " + user);
        boolean isDuplicateUser = userService.isUserAlreadyExists(user.getEmail());

        if(isDuplicateUser){
            model.addAttribute("error", "User already exists in database.");
            log.info("User already exists in database.");
            return "signup";
        }
        User dbUser = userService.save(user);
        session.setAttribute("user", dbUser);
        model.addAttribute("user", dbUser);
        session.setAttribute("name", dbUser.getName());
        model.addAttribute("info", "Welcome "+ dbUser.getName() + "!");
        model.addAttribute("success", "User registered successfully.");
        log.info("User "+ dbUser.getName() + " successfully Registered.");

        return "Index";
    }

}
