package com.todocodeacademy.libros.repository;

import com.todocodeacademy.libros.dto.AutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="autores", url="http://localhost:9001")
public interface IAutoresClient {

    @GetMapping("/autor-por-nombre/{nombreCompleto}")
    public AutorDTO traerAutorPorNombre(@PathVariable("nombreCompleto") String nombreCompleto, @RequestParam String nacionalidad);
}
