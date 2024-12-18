package com.jud_as.todosimple;

import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.User;
import com.jud_as.todosimple.repositories.TaskRepository;
import com.jud_as.todosimple.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTestSetup {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TaskRepository taskRepository;

    protected User testUser;

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
}
