package com.project.toDoList.service;

import com.project.toDoList.dao.UserDao;
import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import com.project.toDoList.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

   public UserDto findByUserName(String userName) {
       Optional<User> user=userDao.findByUsername(userName);
       User user1=null;
       if(user.isPresent()){
           user1=user.get();
       }
       return userMapper.mapToDto(user1);
   }
    public void save(User user){
       user.setRoles("USER");
       user.setActive(1);
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userMapper.mapToDto(userDao.save(user));
    }

}
