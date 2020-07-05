package com.todobackend.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TodoApplication.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
class TodoControllerTestIntergrationTest {
    @Autowired
    MockMvc mockMvc;

    private static List<Todo> todoList = new ArrayList<>();
    private static long id=1;

    static {
        todoList.add(new Todo(id++,"memmy", "learn Java", new Date(), false));
        todoList.add(new Todo(id++,"memmy", "learn PHP", new Date(), false));
        todoList.add(new Todo(id++,"memmy", "Visit friend", new Date(), false));
        todoList.add(new Todo(id++,"memmy", "call friends", new Date(), false));

    }
    String todoListJason= new ObjectMapper().writeValueAsString(todoList);

    TodoControllerTestIntergrationTest() throws JsonProcessingException {
    }

    @Test
    void getTodos() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());


    }


}