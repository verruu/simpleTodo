package com.bjw.todo.serviceTest;

import com.bjw.todo.repositories.Todo;
import com.bjw.todo.repositories.TodoRepository;
import com.bjw.todo.services.TodoService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AllArgsConstructor
public class TodoServiceTest {

    private TodoRepository todoRepository;

    @Test
    void shouldGetAllTodos() {
        Todo todoSample = new Todo("Todo Sample 1", true);
        todoRepository.save(todoSample);
        TodoService todoService = new TodoService(todoRepository);

//        List<Todo> todoList = todoService.getAllTodos();
        Todo firstResult = todoService.getAllTodos().get(0);
//        Todo lastResult = todoService.getAllTodos().get(todoList.size() - 1);

        assertEquals(todoSample.getText(), firstResult.getText());
        assertEquals(todoSample.isCompleted(), firstResult.isCompleted());
        assertEquals(todoSample.getId(), firstResult.getId());
    }
}
