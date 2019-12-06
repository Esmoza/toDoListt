package com.project.toDoList.controller;
import com.project.toDoList.dao.UserDao;
import com.project.toDoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserDao userDao;

    @GetMapping("index")
    public String getView(){
        return "index";
    }

    @GetMapping("login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("signin")
    public String signin(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "login";
        }

        return "redirect:index";
    }


}
