package com.ravindra.javarest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ravindra.javarest.models.Todo;
import com.ravindra.javarest.repositories.ITodoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/todos")
public class TodosController {

    @Autowired
    private ITodoRepository todoRepository;

    // public TodosController() {
    //     this.todoRepository = new TodoRepository();
    // }

    @GetMapping()
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        var todoItem = todoRepository.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        return todoItem;
    }

    @PostMapping()
    public Todo addTodo(@RequestBody Todo todo) {
        return todoRepository.add(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        if(id!=todo.getId()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"Id in request body and path do not match"
            );
        }
        var todoItem = todoRepository.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        return todoRepository.update(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        var todoItem = todoRepository.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        todoRepository.delete(id);
    }
    
    
}
