package com.example.moviewebsite.user_data.repository;

import com.example.moviewebsite.user_data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByEmailAndPassword(String email,String password);
}
