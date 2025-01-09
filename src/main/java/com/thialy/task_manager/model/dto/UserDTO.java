package com.thialy.task_manager.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Password cannot be empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
