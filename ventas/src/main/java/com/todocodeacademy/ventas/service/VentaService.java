package com.todocodeacademy.ventas.service;

import com.todocodeacademy.ventas.model.Venta;
import com.todocodeacademy.ventas.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository repository;

    @Override
    public void crear(Venta venta) {
        repository.save(venta);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Venta> traerTodas() {
        return repository.findAll();
    }

    @Override
    public Venta traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Venta modificar(Long id, Venta venta) {
        this.crear(venta);
        return repository.findById(id).get();
    }
}
