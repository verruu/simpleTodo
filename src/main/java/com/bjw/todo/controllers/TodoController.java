package com.bjw.todo.controllers;

import com.bjw.todo.repositories.Todo;
import com.bjw.todo.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
