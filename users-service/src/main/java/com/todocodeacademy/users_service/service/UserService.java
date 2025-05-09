package com.todocodeacademy.users_service.service;

import com.todocodeacademy.users_service.dto.PostDTO;
import com.todocodeacademy.users_service.dto.UserDTO;
import com.todocodeacademy.users_service.model.User;
import com.todocodeacademy.users_service.repository.IPostsAPI;
import com.todocodeacademy.users_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository repository;
    @Autowired
    private IPostsAPI apiPosts;

    @Override
    public UserDTO getUserAndPosts(Long user_id) {
        //Datos del usuario de la BD
        User user = repository.findById(user_id).orElse(null);

        //Una vez que tengo los datos necesito los posteos
        //Traigo posteos desde la api de posteos
        List<PostDTO> postList = apiPosts.getPostsByUserId(user_id);

        //Unificar datos del usuario + posteos
        //User DTO
        UserDTO userDTO = new UserDTO(user.getUser_id(), user.getName(), user.getLastname(),
        user.getCell_phone(), postList);
        return userDTO;
    }
}
