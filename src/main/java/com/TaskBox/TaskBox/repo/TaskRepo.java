package com.TaskBox.TaskBox.repo;

import com.TaskBox.TaskBox.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
}
