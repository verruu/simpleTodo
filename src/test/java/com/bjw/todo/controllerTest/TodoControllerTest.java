package com.bjw.todo.controllerTest;

import com.bjw.todo.services.TodoService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

@AllArgsConstructor
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private TodoService todoService;

    @Test
    private void shouldGetAllTodos() throws Exception {
//        given
        List<Todo> todoList = new ArrayList<Todo>();
        todoList.add(new Todo(1L, "First todo", false));
        todoList.add(new Todo(2L, "Second todo", true));
//        when
        todoList = todoService.getAllTodos();
//        then
        assertThat(Collections.singletonList(todoList)).
    }
}
