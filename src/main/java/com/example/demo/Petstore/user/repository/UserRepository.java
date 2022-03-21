package com.example.demo.Petstore.user.repository;


import com.example.demo.Petstore.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByUserName(String username);
    boolean existsUserModelByUserName(String username);

}