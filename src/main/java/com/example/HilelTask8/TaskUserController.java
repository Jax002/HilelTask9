package com.example.HilelTask8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskUserController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable int taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/users")
    public void addUser(@RequestParam String username) {
        userService.addUser(username);
    }

    @DeleteMapping("/users/{username}")
    public void removeUser(@PathVariable String username) {
        userService.removeUser(username);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping("/tasks/assign")
    public void assignTask(@RequestParam int taskId, @RequestParam String username) {
        taskService.assignTask(taskId, username, userService);
    }

    @GetMapping("/tasks/status/{status}")
    public List<Task> findTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findTasksByStatus(status);
    }
}