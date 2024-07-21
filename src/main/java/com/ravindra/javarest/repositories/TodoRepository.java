package com.ravindra.javarest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravindra.javarest.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
