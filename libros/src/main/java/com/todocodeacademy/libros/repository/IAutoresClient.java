package com.todocodeacademy.libros.repository;

import com.todocodeacademy.libros.dto.AutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="autores", url="http://localhost:9001/autores")
public interface IAutoresClient {

    @GetMapping("/autor-por-nombre/{nombreCompleto}")
    public AutorDTO traerAutorPorNombre(@PathVariable("nombreCompleto") String nombreCompleto,
                                        @RequestParam String nacionalidad);
    @PostMapping("/")
    public void guardarAutor(@RequestBody AutorDTO autor);

    @PutMapping("/agregar-isbn/{isbn}")
    public void agregarIsbnAAutor(@PathVariable("isbn") String isbn,
                            @RequestParam String nombreCompleto,
                            @RequestParam String nacionalidad);
}
