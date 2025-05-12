package com.todocodeacademy.cities_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class City {
    private Long city_id;
    private String name;
    private String continent;
    private String country;
    private String state;
    //private List<Long> hotels_id;
}
