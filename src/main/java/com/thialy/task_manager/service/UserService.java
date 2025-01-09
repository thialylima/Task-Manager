package com.thialy.task_manager.service;

import java.util.List;
import java.util.Optional;

import com.thialy.task_manager.model.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long is, UserDTO userDTO);

    void deleteUser(Long id);
}
