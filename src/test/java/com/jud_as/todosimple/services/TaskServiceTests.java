package com.jud_as.todosimple.services;
import com.jud_as.todosimple.controllers.TaskController;
import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.User;
import com.jud_as.todosimple.repositories.TaskRepository;
import com.jud_as.todosimple.repositories.UserRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class TaskServiceTests {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    User testUser;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword("testPassword");
        userRepository.save(testUser);

        Task task = new Task();
        task.setUser(testUser);
        task.setDescription("Test Task");
        taskRepository.save(task);
    }

    @Test
    @Transactional
    void testFindById() {
        Task task = taskRepository.findAll().get(0);
        assertNotNull(taskService.findById(task.getId()));
    }
}
