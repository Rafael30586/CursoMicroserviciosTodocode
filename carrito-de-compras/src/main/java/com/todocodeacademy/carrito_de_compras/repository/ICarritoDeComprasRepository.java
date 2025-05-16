package com.todocodeacademy.carrito_de_compras.repository;

import com.todocodeacademy.carrito_de_compras.model.CarritoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoDeComprasRepository extends JpaRepository<CarritoDeCompras,Long> {
}
