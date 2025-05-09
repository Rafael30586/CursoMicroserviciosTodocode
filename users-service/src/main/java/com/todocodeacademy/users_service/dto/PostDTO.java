package com.todocodeacademy.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostDTO {
    private Long id;
    private String title;
    private String user_id;
}
