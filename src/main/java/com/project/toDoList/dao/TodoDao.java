package com.project.toDoList.dao;

import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<Todo, TodoDto> {

//     Todo save(Todo todo);
      Todo findById(long id);
}
