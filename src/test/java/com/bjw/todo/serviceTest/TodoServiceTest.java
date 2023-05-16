package com.bjw.todo.serviceTest;

import com.bjw.todo.repositories.Todo;
import com.bjw.todo.repositories.TodoRepository;
import com.bjw.todo.services.TodoService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TodoServiceTest {

    private final TodoRepository todoRepository;

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }

    @Autowired
    public TodoServiceTest(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    Todo todoSample = new Todo("Todo Sample 1", true);

    @Test
    void shouldGetAllTodos() {
//        given
        todoRepository.save(todoSample);
        TodoService todoService = new TodoService(todoRepository);
//        when
        Todo firstResult = todoService.getAllTodos().get(0);
//        then
        assertEquals(todoSample.getText(), firstResult.getText());
        assertEquals(todoSample.isCompleted(), firstResult.isCompleted());
        assertEquals(todoSample.getId(), firstResult.getId());
    }

    @Test
    void shouldAddTodo() {
//        given
        TodoService todoService = new TodoService(todoRepository);
//        when
        todoService.addTodo(todoSample);
//        then
        assertEquals(1, todoRepository.count());
    }
}
