package com.todocodeacademy.carrito_de_compras.service;

import com.todocodeacademy.carrito_de_compras.model.CarritoDeCompras;
import com.todocodeacademy.carrito_de_compras.repository.ICarritoDeComprasRepository;
import com.todocodeacademy.carrito_de_compras.repository.IProductoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoDeComprasService implements ICarritoDeComprasService{

    @Autowired
    private ICarritoDeComprasRepository repository;
    @Autowired
    private IProductoClient productoClient;

    @Override
    public List<CarritoDeCompras> traerTodos() {
        return repository.findAll();
    }

    @Override
    public CarritoDeCompras traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CarritoDeCompras modificar(Long id, CarritoDeCompras carritoDeCompras) {
        this.crear(carritoDeCompras);
        return repository.findById(id).get();
    }

    @Override
    public void crear(CarritoDeCompras carritoDeCompras) {
        repository.save(carritoDeCompras);
    }

    @Override
    public CarritoDeCompras agregarProducto(Long idProducto,Long idCarritoDeCompras) {
        CarritoDeCompras carritoDeCompras = this.traerPorId(idCarritoDeCompras);
        List<Long> listaProductos = new ArrayList<>();
        listaProductos.add(idProducto);
        carritoDeCompras.setPrecioTotal(carritoDeCompras.getPrecioTotal()+productoClient.traerPorId(idProducto).getPrecioIndividual());
        carritoDeCompras.setListaProductos(listaProductos);
        this.crear(carritoDeCompras);
        return null;
    }
}
