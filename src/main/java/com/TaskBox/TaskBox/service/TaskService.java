package com.TaskBox.TaskBox.service;

import com.TaskBox.TaskBox.entity.TaskEntity;

import java.util.List;

public interface TaskService {

    List<TaskEntity> readAll();

    TaskEntity saveNote(TaskEntity taskEntity);

    TaskEntity findById(Long id);

     void removeNote(Long id);


}
