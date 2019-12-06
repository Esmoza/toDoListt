package com.project.toDoList.service;

import com.project.toDoList.dao.PriorityDao;
import com.project.toDoList.dao.TodoDao;
import com.project.toDoList.dto.PriorityDto;
import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.entity.Priority;
import com.project.toDoList.mapper.PriorityMapper;
import com.project.toDoList.mapper.TodoMapper;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriorityService {
    @Autowired
    private PriorityDao priorityDao;
    @Autowired
    private PriorityMapper priorityMapper;


    public List<PriorityDto> findAll(){
        return priorityMapper.mapToDtoList(priorityDao.findAll());
    }

    public void save(PriorityDto priorityDto){
        priorityDao.save(priorityDto);
        priorityMapper.mapToEntity(priorityDto);
    }

    public Priority findById(Long id) {
        return (Priority) priorityDao.findById(id);
    }

}
