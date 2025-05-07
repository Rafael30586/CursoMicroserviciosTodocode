package com.todocodeacademy.envios.repository;


import com.todocodeacademy.envios.dto.DestinatarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="destinatarios",url="http://localhost:9002/destinatarios")
public interface IDestinatarioClient {

    @GetMapping("/{id}")
    public DestinatarioDTO traerPorId(@PathVariable("id") Long id);
}
