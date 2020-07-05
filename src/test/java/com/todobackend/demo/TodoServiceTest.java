package com.todobackend.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @InjectMocks
    TodoService todoService;


    @Test
    public void getAllTodo_returnsListOfTodo(){
        /*List<Todo>expected= Collections.singletonList(Todo.builder()
                .description("description")
                .dueDate(new Date())
                .username("username")
                .id(1)
                .isDone(false)
                .build());*/

       List<Todo> actual = todoService.getAllTodo();
       assertThat(actual.size()).isEqualTo(4);



    }



}