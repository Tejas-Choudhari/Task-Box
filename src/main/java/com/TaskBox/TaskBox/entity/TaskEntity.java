package com.TaskBox.TaskBox.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Task")
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull
    @Size(min = 4,max = 50,message = " Title must between 4-50 character")
    @Column(name = "Title")
    private String title;

    @NotNull
    @Size(min = 6,max = 1000,message = "Description should be between 6-100 character")
    @Column(name = "Description")
    private String body;

    @Column(name = "Created_At",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = " Updated_At")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
