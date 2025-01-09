package com.thialy.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thialy.task_manager.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
