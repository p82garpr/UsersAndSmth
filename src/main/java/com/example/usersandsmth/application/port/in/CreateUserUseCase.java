package com.example.usersandsmth.application.port.in;

import com.example.usersandsmth.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
