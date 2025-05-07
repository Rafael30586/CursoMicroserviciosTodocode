package com.todocodeacademy.envios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DestinatarioDTO {
    private Long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String numeroTelefono;
}
