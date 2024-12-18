package com.jud_as.todosimple.services;
import com.jud_as.todosimple.BaseTestSetup;
import com.jud_as.todosimple.models.Task;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class TaskServiceTests extends BaseTestSetup {

    @Autowired
    TaskService taskService;

    @Test
    @Transactional
    void testFindById() {
        Task task = taskRepository.findAll().get(0);
        assertNotNull(taskService.findById(task.getId()));
    }
}
