package com.example.usersandsmth.application.port.out;

import com.example.usersandsmth.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
}
