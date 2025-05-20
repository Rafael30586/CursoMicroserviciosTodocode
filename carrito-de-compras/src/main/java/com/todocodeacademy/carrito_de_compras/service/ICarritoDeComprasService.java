package com.todocodeacademy.carrito_de_compras.service;


import com.todocodeacademy.carrito_de_compras.model.CarritoDeCompras;

import java.util.List;

public interface ICarritoDeComprasService{

    public List<CarritoDeCompras> traerTodos();

    public CarritoDeCompras traerPorId(Long id);

    public void eliminarPorId(Long id);

    public CarritoDeCompras modificar(Long id, CarritoDeCompras carritoDeCompras);

    public void crear(CarritoDeCompras carritoDeCompras);

    public CarritoDeCompras agregarProducto(Long idProducto,int cantidadProducto,Long idCarritoDeCompras);

    public void quitarProducto(Long idProducto,Long idCarritoDeCompras);
}
