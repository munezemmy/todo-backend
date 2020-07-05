package com.todobackend.demo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    private long id;
    private  String username;
    private String description;
    private Date dueDate;
    private boolean isDone;



}
