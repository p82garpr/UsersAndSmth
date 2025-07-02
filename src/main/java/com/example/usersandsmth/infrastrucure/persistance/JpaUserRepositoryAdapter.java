package com.example.usersandsmth.infrastrucure.persistance;

import com.example.usersandsmth.application.port.out.UserRepositoryPort;
import com.example.usersandsmth.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springDataUserRepository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.firstName(), user.lastName());
        final UserEntity savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName());
    }

    @Override
    public Optional<User> findById(Long id) {
        final UserEntity savedUser = springDataUserRepository
                .findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("User not found")
                );
        return Optional.of(
                new User(id, "firstName", "lastName"));
    }
}
