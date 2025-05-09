package com.todocodeacademy.posts_service.service;

import com.todocodeacademy.posts_service.model.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getPostsByUser(Long user_id);
}
