package com.thialy.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thialy.task_manager.model.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
