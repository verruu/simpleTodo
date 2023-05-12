package com.bjw.todo.controllerTest;

import com.bjw.todo.repositories.Todo;
import com.bjw.todo.services.TodoService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@AllArgsConstructor
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private TodoService todoService;

    @Test
    void shouldGetAllTodos() throws Exception {
//        given
        List<Todo> todoList = new ArrayList<>();
        todoList.add(new Todo(1L, "First todo", false));
        todoList.add(new Todo(2L, "Second todo", true));
//        when
        when(todoService.getAllTodos()).thenReturn(todoList);
//        then
        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }
}