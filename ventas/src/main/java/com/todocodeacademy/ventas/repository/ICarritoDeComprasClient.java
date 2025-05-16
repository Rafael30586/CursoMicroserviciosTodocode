package com.todocodeacademy.ventas.repository;

import com.todocodeacademy.ventas.dto.CarritoDeComprasDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="carrito-de-compras")
public interface ICarritoDeComprasClient {

    @GetMapping("/carritos-de-compras/{id}")
    public CarritoDeComprasDTO traerPorId(@PathVariable("id") Long id);

}
