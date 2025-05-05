package com.todocodeacademy.platos.service;

import com.todocodeacademy.platos.model.Plato;

import java.util.List;

public interface IPlatoService {

    public void crear(Plato plato);

    public List<Plato> traerTodos();

    public Plato traerPorId(Long id);

    public void borrarPorId(Long id);

    public Plato editar(Long id, Plato plato);
}
