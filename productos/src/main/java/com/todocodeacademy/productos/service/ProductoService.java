package com.todocodeacademy.productos.service;

import com.todocodeacademy.productos.model.Producto;
import com.todocodeacademy.productos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> traerTodos() {
        return repository.findAll();
    }

    @Override
    public Producto traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void crear(Producto producto) {
        repository.save(producto);
    }

    @Override
    public Producto modificar(Long id, Producto producto) {
        this.crear(producto);
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}
