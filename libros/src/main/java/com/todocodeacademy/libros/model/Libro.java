package com.todocodeacademy.libros.model;

import com.todocodeacademy.libros.dto.AutorDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Libro {
    @Id
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private String descripcion;
    @ElementCollection
    private List<AutorDTO> autores;

}
