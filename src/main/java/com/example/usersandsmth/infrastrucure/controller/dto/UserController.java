package com.example.usersandsmth.infrastrucure.controller.dto;

import com.example.usersandsmth.application.port.in.CreateUserUseCase;
import com.example.usersandsmth.application.port.in.GetUserUseCase;
import com.example.usersandsmth.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase){
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request){
        final User user = new User (null,request.firstName(), request.lastName());
        final User userCreated = createUserUseCase.createUser(user);
        return new UserResponse(userCreated.id(), userCreated.firstName(), userCreated.lastName());
    }

    public UserResponse getUser(@PathVariable Long id){
        final User user = getUserUseCase.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("User not found")
        );
        return new UserResponse(user.id(), user.firstName(), user.lastName());
    }
}
