package com.todocodeacademy.productos.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Producto {
    private Long codigo;
    private String nombre;
    private String marca;
    private Double precioIndividual;
}
