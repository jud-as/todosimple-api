package com.jud_as.todosimple.services;

import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.User;
import com.jud_as.todosimple.models.projection.TaskProjection;
import com.jud_as.todosimple.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
                "Task not found! id " + id + " Type: " + Task.class.getName())
        );
    }

    public List<TaskProjection> findAllByUserId(Long userId) {
        List<TaskProjection> tasks = this.taskRepository.findByUser_Id(userId);
        return tasks;
    }

    @Transactional
    public void update(Task taskObj) {
        Task newTaskObj = findById(taskObj.getId());
        newTaskObj.setDescription(taskObj.getDescription());
        this.taskRepository.save(newTaskObj);
    }

    @Transactional
    public Task create(Task taskObj) {
        User user = this.userService.findById(taskObj.getUser().getId());
        taskObj.setId(null);
        taskObj.setUser(user);
        taskObj = this.taskRepository.save(taskObj);
        return taskObj;
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Task cannot be deleted! id: " + id);
        }
    }
}
