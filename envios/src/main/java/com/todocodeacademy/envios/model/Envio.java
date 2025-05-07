package com.todocodeacademy.envios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter @Setter
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaCreacion;
    private String estadoDeProcesamiento;
    private String descripcion;
    private Long idDestinatario;
}
