package com.example.LearningKart.repository;


import com.example.LearningKart.entities.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {
}