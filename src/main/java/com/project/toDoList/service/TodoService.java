package com.project.toDoList.service;

import com.project.toDoList.dao.TodoDao;
import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;
    @Autowired
    private TodoMapper todoMapper;


    public List<TodoDto> findAll(){
        return todoMapper.mapToDtoList(todoDao.findAll());
    }

    public void save(TodoDto todoDto){
      todoDao.save(todoDto);
        todoMapper.mapToEntity(todoDto);
    }
}
