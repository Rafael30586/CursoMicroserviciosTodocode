package com.todocodeacademy.ventas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CarritoDeComprasDTO {
    private Double precioTotal;
    private List<CantidadProductoDTO> listaProductos;
}
