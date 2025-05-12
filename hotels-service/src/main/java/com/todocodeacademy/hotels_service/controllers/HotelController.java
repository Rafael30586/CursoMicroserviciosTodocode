package com.todocodeacademy.hotels_service.controllers;

import com.todocodeacademy.hotels_service.models.Hotel;
import com.todocodeacademy.hotels_service.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService service;

    @GetMapping("/{city_id}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long city_id){
        return service.getHotelsByCityId(city_id);
    }
}
