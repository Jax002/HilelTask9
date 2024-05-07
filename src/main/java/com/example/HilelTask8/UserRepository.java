package com.example.hilel_task_8.repository;

import com.example.hilel_task_8.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}