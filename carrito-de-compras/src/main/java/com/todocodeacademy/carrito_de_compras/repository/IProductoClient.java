package com.todocodeacademy.carrito_de_compras.repository;

import com.todocodeacademy.carrito_de_compras.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="productos")
public interface IProductoClient {

    @GetMapping("/{id}")
    public ProductoDTO traerPorId(@PathVariable("id") Long id);

}
