package com.todocodeacademy.productos.service;

import com.todocodeacademy.productos.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> traerTodos();

    public Producto traerPorId(Long id);

    public void crear(Producto producto);

    public Producto modificar(Long id, Producto producto);

    public void eliminarPorId(Long id);
}
