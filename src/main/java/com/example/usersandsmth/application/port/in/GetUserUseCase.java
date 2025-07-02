package com.example.usersandsmth.application.port.in;

import com.example.usersandsmth.domain.model.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> findById(Long id);
}
