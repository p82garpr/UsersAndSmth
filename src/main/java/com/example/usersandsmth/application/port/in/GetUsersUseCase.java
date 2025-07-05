package com.example.usersandsmth.application.port.in;

import com.example.usersandsmth.domain.model.User;

import java.util.List;

public interface GetUsersUseCase {
    List<User> findAll();
}
