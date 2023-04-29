package com.bjw.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository <Todo, Long> {
}
