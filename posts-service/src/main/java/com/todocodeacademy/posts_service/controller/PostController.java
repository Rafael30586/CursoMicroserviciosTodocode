package com.todocodeacademy.posts_service.controller;


import com.todocodeacademy.posts_service.model.Post;
import com.todocodeacademy.posts_service.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService service;

    @Value("${server.port}") //Esta anotación permite inyectar valores de las application...
    private int serverPort; //...properties en variables

    @GetMapping("/{user_id}")
    public List<Post> getPostsByUserId(@PathVariable Long user_id){
        System.out.println("Etoy en el  puerto: "+ serverPort);
        return service.getPostsByUser(user_id);
    }
}
