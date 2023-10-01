package com.example.Login_System.repository;


import com.example.Login_System.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByEmail(String email);

}
