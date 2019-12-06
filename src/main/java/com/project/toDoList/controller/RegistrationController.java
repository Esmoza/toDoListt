package com.project.toDoList.controller;

import com.project.toDoList.dao.UserDao;
import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import com.project.toDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @ModelAttribute("userdto")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping("signup")
    public String showSignupForm(){
        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(user);
        return "redirect:index";
    }





}
