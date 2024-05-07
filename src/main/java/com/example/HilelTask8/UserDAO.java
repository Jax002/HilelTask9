package com.example.HilelTask8;

import com.example.hilel_task_8.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUser(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(String username);
}