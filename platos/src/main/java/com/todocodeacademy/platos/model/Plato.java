package com.todocodeacademy.platos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero_plato;
    private String nombre;
    private Double precio;
    private String breve_descripcion;
    @ElementCollection
    private List<String> lista_ingredientes;
}
