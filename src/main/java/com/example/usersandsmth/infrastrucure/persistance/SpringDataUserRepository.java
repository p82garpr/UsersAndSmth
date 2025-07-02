package com.example.usersandsmth.infrastrucure.persistance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long>{

}
