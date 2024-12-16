package com.jud_as.todosimple.repositories;

import com.jud_as.todosimple.models.Task;
import com.jud_as.todosimple.models.projection.TaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<TaskProjection> findByUser_Id(Long userId);
}

