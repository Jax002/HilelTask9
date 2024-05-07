package com.example.hilel_task_8;

import com.example.hilel_task_8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Додати користувача
    public void addUser(User user) {
        userRepository.save(user);
    }

    // Видалити користувача
    public void removeUser(String username) {
        userRepository.deleteById(username);
    }

    // Отримати користувача за його ім'ям
    public User getUser(String username) {
        return userRepository.findById(username).orElse(null);
    }
}