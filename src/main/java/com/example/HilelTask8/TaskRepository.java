package com.example.hilel_task_8.repository;

import com.example.hilel_task_8.Task;
import com.example.hilel_task_8.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByTaskStatus(TaskStatus status);
}