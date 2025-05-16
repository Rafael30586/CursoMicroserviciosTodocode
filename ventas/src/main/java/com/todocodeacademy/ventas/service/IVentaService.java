package com.todocodeacademy.ventas.service;

import com.todocodeacademy.ventas.dto.CarritoDeComprasDTO;
import com.todocodeacademy.ventas.model.Venta;

import java.util.List;

public interface IVentaService {

    public void crear(Venta venta);

    public void eliminarPorId(Long id);

    public List<Venta> traerTodas();

    public Venta traerPorId(Long id);

    public Venta modificar(Long id, Venta venta);

    public CarritoDeComprasDTO traerCarrito(Long idVenta);
}
