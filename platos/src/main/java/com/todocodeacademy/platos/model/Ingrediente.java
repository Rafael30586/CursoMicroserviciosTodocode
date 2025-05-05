package com.todocodeacademy.platos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Ingrediente {
    private Long id_ingrediente;
    private String nombreIngrediente;

    public Ingrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }
}
