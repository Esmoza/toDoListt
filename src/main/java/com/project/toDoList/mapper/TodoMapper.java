package com.project.toDoList.mapper;

import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper implements CustomMapper<Todo, TodoDto> {
    @Override
    public TodoDto mapToDto(Todo entity) {
       TodoDto todoDto=new TodoDto();
        BeanUtils.copyProperties(entity,todoDto);
        return todoDto;
    }

    @Override
    public Todo mapToEntity(TodoDto todoDto) {
        Todo todo= new Todo();
        BeanUtils.copyProperties(todoDto, todo);
        return todo;
    }

    public List<TodoDto> mapToDtoList(Iterable<Todo> todos){
        List<TodoDto> todoDtos=new ArrayList<>();
        for(Todo todo:todos){
            todoDtos.add(mapToDto(todo));
        }
        return todoDtos;
    }
}
