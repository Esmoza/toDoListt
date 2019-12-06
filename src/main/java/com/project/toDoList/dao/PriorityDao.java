package com.project.toDoList.dao;

import com.project.toDoList.dto.PriorityDto;
import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityDao extends JpaRepository<Priority, PriorityDto> {
    void save(PriorityDto priorityDto);

    List<Priority> findById(Long id);
}
