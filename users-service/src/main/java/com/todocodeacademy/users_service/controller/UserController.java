package com.todocodeacademy.users_service.controller;

import com.todocodeacademy.users_service.dto.UserDTO;
import com.todocodeacademy.users_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/posts/{user_id}")
    public UserDTO getUserAndPosts(@PathVariable Long user_id){
        UserDTO userDTO = service.getUserAndPosts(user_id);

        return userDTO;
    }
}
