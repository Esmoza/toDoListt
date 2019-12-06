package com.project.toDoList.controller;

import com.project.toDoList.dao.PriorityDao;
import com.project.toDoList.dao.TodoDao;
import com.project.toDoList.dto.PriorityDto;
import com.project.toDoList.dto.TodoDto;
import com.project.toDoList.dto.TodoListDto;
import com.project.toDoList.entity.Priority;
import com.project.toDoList.entity.Todo;
import com.project.toDoList.service.PriorityService;
import com.project.toDoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo/")
public class TodoController {
    @Autowired
    public TodoDao todoDao;
    @Autowired
    public PriorityDao priorityDao;

    @Autowired
    public PriorityService priorityService;

    @GetMapping("form")
    public String showForm(Todo todo, Priority priority,Model model){
        List<PriorityDto> priorities=priorityService.findAll();
        model.addAttribute("priorities",priorities);
        return "add-todo";
    }

    @GetMapping("list")
    public String showTodos(Model model){
        List<TodoListDto> listOfTodo = new ArrayList<>();
        List<Todo> todos = todoDao.findAll();
        for(Todo todo: todos){
            TodoListDto todoList = new TodoListDto();
            todoList.setId(todo.getId());
            todoList.setTitle(todo.getTitle());

            listOfTodo.add(todoList);
        }
        model.addAttribute("todos",listOfTodo);
        return "show-details";
    }

    @PostMapping("add")
    public String addTodo(@Valid Todo todo, BindingResult result, Model model){
        if(result.hasErrors())
            return "add-todo";
        todoDao.save(todo);
        return "redirect:list";
    }
    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Todo todo =todoDao.findById(id);
        model.addAttribute("todo",todo);
        return "update-todo";
    }

    @GetMapping("details/{id}")
    @ResponseBody
    public TodoDto GetTodoDetails(@PathVariable("id") long id){
        Todo todo = todoDao.findById(id);
        List<Priority> priorities = priorityDao.findAll();
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setNote(todo.getNote());
        todoDto.setDueDate(todo.getDueDate());

        List<PriorityDto> listOfPriorities = new ArrayList<>();

        for(Priority priority: priorities){
            PriorityDto priorityDto = new PriorityDto();
            priorityDto.setId(priority.getId());
            priorityDto.setName(priority.getName());

            listOfPriorities.add(priorityDto);
        }
        todoDto.setPriority(todo.getPriority().getId());
        todoDto.setPriorityDtoList(listOfPriorities);
        return todoDto;
    }

    @PostMapping("update-todo/{id}")
    public @ResponseBody String updateTodo(@PathVariable("id") long id, @RequestBody TodoDto model){
        Todo todo =todoDao.findById(id);
        todo.setTitle(model.getTitle());
        todo.setNote(model.getNote());
        todoDao.save(todo);
        return "Todo edited successfully";
    }

    @GetMapping("delete/{id}")
    public String deleteTodo(@PathVariable("id") long id, Model model) {
        Todo todo = todoDao.findById(id);
        todoDao.delete(todo);
        model.addAttribute("todo", todoDao.findAll());
        return "show-details";
    }



}
