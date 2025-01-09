package com.thialy.task_manager.service;

import java.util.List;
import java.util.Optional;

import com.thialy.task_manager.model.dto.TaskRequestDTO;
import com.thialy.task_manager.model.entity.Task;

public interface TaskService {

    TaskRequestDTO createTask(TaskRequestDTO taskDTO);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();
    
    Task updateTask(Long id, TaskRequestDTO taskDTO);

    void deleteTask(Long id);
} 
