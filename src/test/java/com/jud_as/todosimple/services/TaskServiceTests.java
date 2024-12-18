package com.jud_as.todosimple.services;
<<<<<<< HEAD
import com.jud_as.todosimple.controllers.TaskController;
import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.User;
import com.jud_as.todosimple.repositories.TaskRepository;
import com.jud_as.todosimple.repositories.UserRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
=======
import com.jud_as.todosimple.BaseTestSetup;
import com.jud_as.todosimple.models.Task;
import jakarta.transaction.Transactional;
>>>>>>> 742a8b7a1e80e5099af1faadcf49d511469f340a
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
<<<<<<< HEAD
public class TaskServiceTests {
=======
public class TaskServiceTests extends BaseTestSetup {
>>>>>>> 742a8b7a1e80e5099af1faadcf49d511469f340a

    @Autowired
    TaskService taskService;

<<<<<<< HEAD
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

=======
>>>>>>> 742a8b7a1e80e5099af1faadcf49d511469f340a
    @Test
    @Transactional
    void testFindById() {
        Task task = taskRepository.findAll().get(0);
        assertNotNull(taskService.findById(task.getId()));
    }
}
