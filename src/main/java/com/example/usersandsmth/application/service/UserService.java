package com.example.usersandsmth.application.service;

import com.example.usersandsmth.application.port.in.CreateUserUseCase;
import com.example.usersandsmth.application.port.in.GetUserUseCase;
import com.example.usersandsmth.application.port.out.UserRepositoryPort;
import com.example.usersandsmth.domain.model.User;
import com.example.usersandsmth.domain.service.UserValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(User user) {
        if(!UserValidationService.isValidFirstName(user)){
            throw new IllegalArgumentException("Invalid user");
        }
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryPort.findById(id);
    }
}
