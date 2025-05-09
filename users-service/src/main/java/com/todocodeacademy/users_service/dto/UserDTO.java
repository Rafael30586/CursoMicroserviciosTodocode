package com.todocodeacademy.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDTO {

    private Long user_id;
    private String name;
    private String lastname;
    private String cell_phone;
    private List<PostDTO> postsList;
}
