package com.todocodeacademy.carrito_de_compras.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Embeddable
public class CantidadProductoDTO {
    private Long productoId;
    private int cantidadProducto;
}
