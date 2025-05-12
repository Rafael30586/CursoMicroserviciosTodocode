package com.todocodeacademy.cities_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CityDTO {
    private Long citi_id;
    private String name;
    private String country;
    private String continent;
    private String state;
    private List<HotelDTO> hotelList;
}
