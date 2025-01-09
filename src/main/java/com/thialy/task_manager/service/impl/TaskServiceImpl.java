package com.thialy.task_manager.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thialy.task_manager.mapper.TaskMapper;
import com.thialy.task_manager.model.dto.TaskRequestDTO;
import com.thialy.task_manager.model.entity.Task;
import com.thialy.task_manager.repository.TaskRepository;
import com.thialy.task_manager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskRequestDTO createTask(TaskRequestDTO taskDTO) {
        Task task = TaskMapper.mapToEntity(taskDTO);
        task.setRegistrationDate(LocalDateTime.now());
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToRequestDTO(savedTask);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll().stream().toList();
    }

    @Override
    public Task updateTask(Long id, TaskRequestDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        existingTask.setDescription(taskDTO.getDescription());
        existingTask.setStatus(taskDTO.getStatus());
        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setPriority(taskDTO.getPriority());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        taskRepository.delete(task);
    }
}
