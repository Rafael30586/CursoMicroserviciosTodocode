package com.todocodeacademy.carrito_de_compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="carritos_de_compras")
public class CarritoDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="precio_total")
    private Double precioTotal;
    @ElementCollection
    @Column(name="lista_productos")
    private List<Long> listaProductos;
}
