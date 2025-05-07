package com.todocodeacademy.destinatarios.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Destinatario {
    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String numeroTelefono;
}
