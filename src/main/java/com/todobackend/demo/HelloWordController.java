package com.todobackend.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin("*")
public class HelloWordController {

    @GetMapping("/hello")
    public Student helloWord(){

        //throw new RuntimeException("some error has happened");
        return new Student("Emmanuel ");
    }

    @GetMapping("/hello/{name}")
    public Student studentbyName(@PathVariable String name){

        //throw new RuntimeException("some error has happened");
        return new Student(name);
    }
}
