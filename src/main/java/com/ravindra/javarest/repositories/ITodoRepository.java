package com.ravindra.javarest.repositories;

import java.util.List;

import com.ravindra.javarest.models.Todo;

public interface ITodoRepository {
    List<Todo> findAll();

    Todo findById(long id);

    Todo add(Todo todo);

    Todo update(Todo todo);

    void delete(Long id);
}
