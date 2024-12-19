package com.jud_as.todosimple.controllers;


import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.projection.TaskProjection;
import com.jud_as.todosimple.services.TaskService;
import com.jud_as.todosimple.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    @Autowired // Dependency injection
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task taskObj = this.taskService.findById(id);
        return ResponseEntity.ok().body(taskObj);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Task taskObj) {
        this.taskService.create(taskObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody Task taskObj, @PathVariable Long id) {
        taskObj.setId(id);
        this.taskService.update(taskObj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskProjection>> findAllByUserId(@PathVariable Long userId) {
        userService.findById(userId);
        List<TaskProjection> tasks = this.taskService.findAllByUserId(userId);
        return ResponseEntity.ok().body(tasks);
    }


}
