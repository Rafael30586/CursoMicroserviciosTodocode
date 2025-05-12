package com.todocodeacademy.cities_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class HotelDTO {
    private Long id;
    private String name;
    private int stars;
    private Long city_id;
}
