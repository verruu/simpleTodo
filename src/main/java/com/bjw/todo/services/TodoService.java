package com.bjw.todo.services;

import com.bjw.todo.repositories.Todo;
import com.bjw.todo.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
