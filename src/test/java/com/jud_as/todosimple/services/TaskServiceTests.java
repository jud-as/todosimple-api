package services;
import com.jud_as.todosimple.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class TaskServiceTests {

    @Autowired
    TaskService taskService;

    @Test
    void testFindById() {
        assertNotNull(taskService.findById(1L));
    }
}
