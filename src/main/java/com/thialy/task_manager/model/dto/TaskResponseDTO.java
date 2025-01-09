// package com.thialy.task_manager.model.dto;

// import java.time.LocalDateTime;

// import com.thialy.task_manager.model.enums.Priority;
// import com.thialy.task_manager.model.enums.Status;

// import jakarta.persistence.Column;
// import jakarta.validation.constraints.NotNull;

// public class TaskResponseDTO {
//     @NotNull(message = "Title cannot be empty")
//     private String title;

//     @NotNull(message = "Description cannot be empty")
//     private String description;

//     @NotNull(message = "Priority cannot be empty")
//     private Priority priority;

//     @NotNull(message = "Status cannot be empty")
//     private Status status;

//     @Column(name = "registration_date", nullable = false)
//     private LocalDateTime registrationDate;

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public Priority getPriority() {
//         return priority;
//     }

//     public void setPriority(Priority priority) {
//         this.priority = priority;
//     }

//     public Status getStatus() {
//         return status;
//     }

//     public void setStatus(Status status) {
//         this.status = status;
//     }

//     public LocalDateTime getRegistrationDate() {
//         return registrationDate;
//     }

//     public void setRegistrationDate(LocalDateTime registrationDate) {
//         this.registrationDate = registrationDate;
//     }
    
// }
