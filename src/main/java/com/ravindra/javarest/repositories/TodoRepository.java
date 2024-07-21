package com.ravindra.javarest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.ravindra.javarest.models.Todo;

@Repository
public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo add(Todo todo) {
        todo.setId(counter.incrementAndGet());
        todos.add(todo);
        return todo;
    }

    public Todo update(Todo todo) {
        for (Todo t : todos) {
            if (t.getId() == todo.getId()) {
                delete(t.getId());
                todos.add(todo);
                return todo;
            }
        }
        return null;
    }

    public void delete(Long id) {
        todos.removeIf(todo->todo.getId() == id);
    }
}
