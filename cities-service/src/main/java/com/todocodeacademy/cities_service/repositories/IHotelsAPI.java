package com.todocodeacademy.cities_service.repositories;

import com.todocodeacademy.cities_service.dtos.HotelDTO;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="hotels-service")
public interface IHotelsAPI {

    @GetMapping("/hotels/{city_id}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
