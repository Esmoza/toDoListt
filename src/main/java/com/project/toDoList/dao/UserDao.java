package com.project.toDoList.dao;

import com.project.toDoList.dto.UserDto;
import com.project.toDoList.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDao extends JpaRepository<User, UserDto> {

    Optional<User> findByUsername(String username);
    User save(UserDto userDto);
}
