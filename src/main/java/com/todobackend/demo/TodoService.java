package com.todobackend.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {



    private static List<Todo> todoList = new ArrayList<>();
    private static long id = 1;

    static {
        todoList.add(new Todo(id++, "memmy", "learn Java", new Date(), false));
        todoList.add(new Todo(id++, "memmy", "learn PHP", new Date(), false));
        todoList.add(new Todo(id++, "memmy", "Visit friend", new Date(), false));
        todoList.add(new Todo(id++, "memmy", "call friends", new Date(), false));

    }

//       public List<Todo>getAllTodo(){
//            return todoList;
//        }
//


    public Todo deleteById(long id) {
        Todo todo = todoList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (todo != null) {
            todoList.remove(todo);
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        return todoList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Todo addTodo(Todo todo) {
        todoList.add(todo);
        return todo;
    }


    public Todo updateTodo(Todo todo, long id) {
        Todo todoFromDb = todoList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (todoFromDb != null) {
            todoList.set(todoList.indexOf(todoFromDb), todo);
            return todo;
        }
        return null;
    }

    public List<Todo> getAllTodo() {
        return todoList;
    }
}
