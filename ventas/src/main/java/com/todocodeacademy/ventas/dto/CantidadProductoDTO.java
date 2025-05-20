package com.todocodeacademy.ventas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CantidadProductoDTO {
    private Long productoId;
    private int cantidadProducto;
}
