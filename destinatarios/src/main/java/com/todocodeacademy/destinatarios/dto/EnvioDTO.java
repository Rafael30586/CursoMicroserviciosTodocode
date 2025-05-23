package com.todocodeacademy.destinatarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EnvioDTO {
    private Long id;
    private LocalDate fechaCreacion;
    private String estadoDeProcesamiento;
    private String descripcion;
}
