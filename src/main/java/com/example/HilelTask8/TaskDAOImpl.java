package com.example.hilel_task_8.dao;

import com.example.hilel_task_8.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("jdbc")
public class TaskDAOImpl implements TaskDAO {

    private final Map<Integer, Task> tasks = new HashMap<>();

    @Override
    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }
}