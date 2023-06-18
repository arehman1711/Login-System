package com.example.LearningKart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LearningKartApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningKartApplication.class, args);
        log.info("Running Succsessfully");
    }

}
