package com.wmart.todoapp.api;

import com.wmart.todoapp.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    List<Task> tasks = new ArrayList<>();


    @GetMapping
    public List<Task> findAllTasks(){
        return tasks;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }


}
