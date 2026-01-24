package com.prasanna.jpa_one_to_many_blog.service;

import com.prasanna.jpa_one_to_many_blog.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);


    UserDto getUserById(Long id);


    List<UserDto> getAllUsers();


    UserDto updateUser(Long id, UserDto userDto);


    void deleteUser(Long id);
}
