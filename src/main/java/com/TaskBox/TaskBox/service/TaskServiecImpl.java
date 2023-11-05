package com.TaskBox.TaskBox.service;

import com.TaskBox.TaskBox.entity.TaskEntity;
import com.TaskBox.TaskBox.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiecImpl implements TaskService{

    @Autowired
    private TaskRepo taskRepo;
    @Override
    public List<TaskEntity> readAll() {
        return taskRepo.findAll();
    }

    @Override
    public TaskEntity saveNote(TaskEntity taskEntity) {
        return taskRepo.save(taskEntity);
    }
}
