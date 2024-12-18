package com.jud_as.todosimple.services;
import com.jud_as.todosimple.BaseTestSetup;
import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.projection.TaskProjection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests extends BaseTestSetup {


    @Test
    void findAllByUserId() {
        for (int i = 1; i <=10; i++) {
            Task task = new Task();
            task.setUser(testUser);
            task.setDescription("Test Task " + i);
            this.taskRepository.save(task);
        }
        List<TaskProjection> tasks = this.taskRepository.findByUser_Id(testUser.getId());
        assertTrue(tasks.size() >= 10, "Not all the tasks are associated with the user");
    }
}
