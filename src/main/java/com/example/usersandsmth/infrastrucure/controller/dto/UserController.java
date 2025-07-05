package com.example.usersandsmth.infrastrucure.controller.dto;

import com.example.usersandsmth.application.port.in.CreateUserUseCase;
import com.example.usersandsmth.application.port.in.GetUserUseCase;
import com.example.usersandsmth.application.port.in.GetUsersUseCase;
import com.example.usersandsmth.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, GetUsersUseCase getUsersUseCase){
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request){
        final User user = new User (null,request.firstName(), request.lastName());
        final User userCreated = createUserUseCase.createUser(user);
        System.out.println(user);
        System.out.println(userCreated);

        return new UserResponse(userCreated.id(), userCreated.firstName(), userCreated.lastName());
    }
    
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        final User user = getUserUseCase.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("User not found")
        );
        return new UserResponse(user.id(), user.firstName(), user.lastName());
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        final List<UserResponse> ListOfUsers = new java.util.ArrayList<>(List.of());
        final List<User> users = getUsersUseCase.findAll();
        for(User user: users){
            ListOfUsers.add(new UserResponse(user.id(), user.firstName(), user.lastName()));
        }
        return ListOfUsers;

    }
}
