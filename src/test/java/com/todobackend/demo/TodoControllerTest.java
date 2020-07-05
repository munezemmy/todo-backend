package com.todobackend.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoController.class)
class TodoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    TodoService todoService;

    @Test
    void getTodos() throws Exception {

        List<Todo> todos = Arrays.asList(new Todo(1, "emmy", "Testing", new Date(), false));
        Mockito.when(todoService.getAllTodo()).thenReturn(todos);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse().toString());
        Mockito.verify(todoService).getAllTodo();
    }


}