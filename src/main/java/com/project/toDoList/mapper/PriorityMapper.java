package com.project.toDoList.mapper;

import com.project.toDoList.dto.PriorityDto;
import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.entity.Priority;
import com.project.toDoList.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PriorityMapper implements CustomMapper<Priority, PriorityDto> {

    @Override
    public PriorityDto mapToDto(Priority entity) {
        PriorityDto priorityDto=new PriorityDto();
        BeanUtils.copyProperties(entity,priorityDto);
        return priorityDto;
    }

    @Override
    public Priority mapToEntity(PriorityDto priorityDto) {
        Priority priority=new Priority();
        BeanUtils.copyProperties(priorityDto,priority);
        return priority;
    }

    public List<PriorityDto> mapToDtoList(Iterable<Priority> priorities){
        List<PriorityDto> priorityDtos=new ArrayList<>();
        for(Priority priority:priorities){
            priorityDtos.add(mapToDto(priority));
        }
        return priorityDtos;
    }
}
