package com.thialy.task_manager.mapper;

import org.springframework.stereotype.Component;

import com.thialy.task_manager.model.dto.UserDTO;
import com.thialy.task_manager.model.entity.User;

@Component
public class UserMapper {
    
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
