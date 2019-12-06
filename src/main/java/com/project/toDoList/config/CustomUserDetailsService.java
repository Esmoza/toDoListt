package com.project.toDoList.config;


import com.project.toDoList.dao.UserDao;
import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import com.project.toDoList.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    public UserDto findByUserName(String userName) {
        Optional<User> user=userDao.findByUsername(userName);
        User user1=null;
        if(user.isPresent()){
            user1=user.get();
        }
        return userMapper.mapToDto(user1);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDao.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser.map(CustomUserDetails:: new).get();
    }
}
