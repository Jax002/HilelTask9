package com.example.hilel_task_8;

import com.example.hilel_task_8.repository.TaskRepository;
import com.example.hilel_task_8.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskDAO taskDAO;
    private final String databaseAccessType;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskDAO taskDAO, @Value("${database.access.type}") String databaseAccessType) {
        this.taskRepository = taskRepository;
        this.taskDAO = taskDAO;
        this.databaseAccessType = databaseAccessType;
    }


    public void addTask(Task task) {
        if ("jpa".equals(databaseAccessType)) {
            taskRepository.save(task);
        } else if ("jdbc".equals(databaseAccessType)) {
            taskDAO.addTask(task);
        } else {
            throw new IllegalArgumentException("Unsupported database access type: " + databaseAccessType);
        }
    }


    public Task getTask(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }


    public void assignTask(int taskId, String username, UserService userService) {
        Task task = getTask(taskId);
        if (task != null) {
            User user = userService.getUser(username);
            if (user != null) {
                user.assignTask(task);
            }
        }
    }


    public List<Task> findTasksByStatus(TaskStatus status) {
        return taskRepository.findAllByTaskStatus(status);
    }
}