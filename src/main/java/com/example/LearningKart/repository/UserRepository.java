package com.example.LearningKart.repository;


import com.example.LearningKart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByEmail(String email);

}
