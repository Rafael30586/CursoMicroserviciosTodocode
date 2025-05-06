package com.todocodeacademy.libros.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public class AutorDTO {
    private String nombreCompleto;
    private String nacionalidad;
}
