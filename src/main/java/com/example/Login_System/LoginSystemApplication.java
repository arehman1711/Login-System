package com.example.Login_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LoginSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSystemApplication.class, args);

        log.info("Running Succsessfully");

    }

}
