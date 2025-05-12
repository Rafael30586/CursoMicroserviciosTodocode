package com.todocodeacademy.hotels_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Hotel {
    private Long id;
    private String name;
    private int stars;
    private Long city_id;
}
