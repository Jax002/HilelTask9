package com.example.hilel_task_8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    //select db in taskservice
    @Value("${database.access.type}")
    private static String databaseAccessType;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        TaskService taskService = context.getBean(TaskService.class);
        UserService userService = context.getBean(UserService.class);

        Task task = new Task("Task 1", "Description 1");
        taskService.addTask(task);
        userService.addUser("Evgen");
        taskService.assignTask(task.getTaskId(), "Evgen", userService);

        context.close();
    }
}