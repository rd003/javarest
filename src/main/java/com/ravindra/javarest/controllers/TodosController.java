package com.ravindra.javarest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ravindra.javarest.models.Todo;
import com.ravindra.javarest.services.ITodoService;

import java.util.List;

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

    private ITodoService todoService;

    public TodosController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<Todo> getAllTodos() {
        try {
        return todoService.findAll();
    } catch (Exception ex) {
            System.out.println(ex);
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        try{
        var todoItem = todoService.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        return todoItem;
    }catch (Exception ex) {
        System.out.println(ex);
        throw new ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    }

    @PostMapping()
    public Todo addTodo(@RequestBody Todo todo) {
        try{
        return todoService.add(todo);
        }catch (Exception ex) {
            System.out.println(ex);
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        if (id != todo.getId()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Id in request body and path do not match");
        }
        try{
        var todoItem = todoService.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        return todoService.update(todo);
       }catch (Exception ex) {
        System.out.println(ex);
        throw new ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR
        );
       }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        try{
        var todoItem = todoService.findById(id);
        if (todoItem == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"todo with id " + id + " not found"
            );
        }
        todoService.delete(id);
       }catch (Exception ex) {
        System.out.println(ex);
        throw new ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR
        );
      }
    }
    
    
}
