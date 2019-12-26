package com.project.toDoList.controller;

import com.project.toDoList.dao.UserDao;
import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import com.project.toDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute("userdto")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping("signup")
    public String showSignupForm() {
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

    @GetMapping("update/{username}")
    public String showUpdateForm(@PathVariable("username") String username, Model model) {
        Optional<User> user = userDao.findByUsername(username);
        User user1 = null;
        if (user.isPresent()) {
            user1 = user.get();
             System.out.println(user1.getEmail());
        }
        model.addAttribute("user", user1);
        model.addAttribute("user", userService.findByUserName(username));
        return "profile";
    }

    @PostMapping("update/{username}")
    public String updateUser(@PathVariable("username") String username, @Valid User user, BindingResult result,
                             Model model) {

        Optional<User> userOptional = userDao.findByUsername(username);
        User user1 = null;
            if (userOptional.isPresent()) {
                user1 = userOptional.get();

            }
        if (result.hasErrors()) {
            return "profile";
        }
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setFirstname(user.getFirstname());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setLocation(user.getLocation());
        userDao.save(user1);
        return "profile";
    }
}