package com.ravindra.javarest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ravindra.javarest.models.Todo;
import com.ravindra.javarest.repositories.TodoRepository;

@Service
public class TodoService implements ITodoService {
    private TodoRepository todoRepo;

    public TodoService(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> findAll() {
        return todoRepo.findAll();
    }

    public Todo findById(long id) {
        return todoRepo.findById(id).orElse(null);
    }

    public Todo add(Todo todo) {
        todo.setCompleted(false);
        return todoRepo.save(todo);
    }

    public Todo update(Todo todo) {
        return todoRepo.save(todo);
    }

    public void delete(Long id) {
        todoRepo.deleteById(id);
    }
}
