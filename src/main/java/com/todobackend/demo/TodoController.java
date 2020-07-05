package com.todobackend.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo>getAllTodo(@PathVariable String username){
        return todoService.getAllTodo();
    }

    @GetMapping("/todos")
    public ResponseEntity getTodos(){
        return new ResponseEntity(todoService.getAllTodo(), HttpStatus.OK);
    }
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity deleteById(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if (todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable long id){

        return todoService.findById(id);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity save(@PathVariable String username, @RequestBody Todo todo){
        return new ResponseEntity(todoService.addTodo(todo), HttpStatus.OK);
    }
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity updateTodoById(@RequestBody Todo todo, @PathVariable long id){

        return new ResponseEntity( todoService.updateTodo(todo,id), HttpStatus.OK);
    }
}
