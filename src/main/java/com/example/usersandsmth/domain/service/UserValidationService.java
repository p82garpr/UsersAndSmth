package com.example.usersandsmth.domain.service;

import com.example.usersandsmth.domain.model.User;

public class UserValidationService {

    public static boolean isValidFirstName(User user){
        return user.firstName().isEmpty() && user.lastName().isEmpty();
    }
}
