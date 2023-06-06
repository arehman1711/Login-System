package com.example.LearningKart.service.interfaces;


import com.example.LearningKart.entities.User;

public interface UserService {

    boolean isValidUser(User user);
    boolean isUserAlreadyExists(String email);

    User getUserByEmail(String email);

    User save(User user);


}
