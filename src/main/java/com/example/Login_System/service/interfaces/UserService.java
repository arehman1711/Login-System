package com.example.Login_System.service.interfaces;


import com.example.Login_System.entities.User;

public interface UserService {

    boolean isValidUser(User user);
    boolean isUserAlreadyExists(String email);

    User getUserByEmail(String email);

    User save(User user);


}
