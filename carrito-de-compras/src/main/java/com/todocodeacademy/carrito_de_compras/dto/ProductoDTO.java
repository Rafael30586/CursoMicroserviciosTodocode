package com.todocodeacademy.carrito_de_compras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ProductoDTO {
    private String nombre;
    private Double precioIndividual;
}
