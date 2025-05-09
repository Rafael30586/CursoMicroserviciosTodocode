package com.todocodeacademy.users_service.repository;

import com.todocodeacademy.users_service.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="posts-service") //No hace falta colocar la url porque ya tiene el nombre...
public interface IPostsAPI {//..registrado en eureka server

    @GetMapping("/posts/{user_id}")
    public List<PostDTO> getPostsByUserId(@PathVariable("user_id") Long user_id);
}
