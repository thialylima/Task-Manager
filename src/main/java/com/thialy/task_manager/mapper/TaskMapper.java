package com.thialy.task_manager.mapper;

import com.thialy.task_manager.model.dto.TaskRequestDTO;
import com.thialy.task_manager.model.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    // Mapeia TaskRequestDTO para Task
    public static Task mapToEntity(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.getTitle());
        task.setDescription(taskRequestDTO.getDescription());
        task.setPriority(taskRequestDTO.getPriority());
        task.setStatus(taskRequestDTO.getStatus());
        return task;
    }

    // Mapeia Task para TaskRequestDTO
    public static TaskRequestDTO mapToRequestDTO(Task task) {
        TaskRequestDTO requestDTO = new TaskRequestDTO();
        requestDTO.setTitle(task.getTitle());
        requestDTO.setDescription(task.getDescription());
        requestDTO.setPriority(task.getPriority());
        requestDTO.setStatus(task.getStatus());
        return requestDTO;
    }
}
