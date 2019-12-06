package com.project.toDoList.mapper;

import com.project.toDoList.dao.UserDao;
import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<User, UserDto> {


    @Override
    public UserDto mapToDto(User entity) {
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(entity,userDto);
        return userDto;
    }

    @Override
    public User mapToEntity(UserDto userDto) {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }
}
