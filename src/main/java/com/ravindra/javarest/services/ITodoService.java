package com.ravindra.javarest.services;

import java.util.List;

import com.ravindra.javarest.models.Todo;

public interface ITodoService {
    List<Todo> findAll();

    Todo findById(long id);

    Todo add(Todo todo);

    Todo update(Todo todo);

    void delete(Long id);
}
