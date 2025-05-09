package com.todocodeacademy.posts_service.service;

import com.todocodeacademy.posts_service.model.Post;
import com.todocodeacademy.posts_service.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository repository;

    @Override
    public List<Post> getPostsByUser(Long user_id) {
        return repository.findPostByUserId(user_id);
    }
}
