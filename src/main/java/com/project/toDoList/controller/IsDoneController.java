package com.project.toDoList.controller;

import com.project.toDoList.dao.TodoDao;
import com.project.toDoList.entity.Todo;
import com.project.toDoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/update/")
public class IsDoneController {

    @Autowired
    public TodoDao todoDao;
    @Autowired
    public TodoService todoService;

    @PostMapping("done/{id}")
    @ResponseBody
    public Todo isDone(@PathVariable("id") long id, @RequestParam("isDone") boolean isDone) {
        if (id==0) {
            return null;
        }
        Todo todo = todoDao.findById(id);
        todo.setDone(isDone);
        todoService.save(todo);
        return todo;
    }

}
