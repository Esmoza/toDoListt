package com.project.toDoList.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private int active;
}
