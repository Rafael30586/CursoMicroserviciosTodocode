package com.todocodeacademy.ingredientes.service;


import com.todocodeacademy.ingredientes.model.Ingrediente;

import java.util.List;

public interface IIngredienteService {

    public void crearIngrediente(Ingrediente ingrediente);

    public List<Ingrediente> traerIngredientes();

    public void borrarIngrediente(Long id);

    public Ingrediente modificarIngrediente(Long id,Ingrediente ingrediente);

    public Ingrediente encontrarIngrediente(Long id);

    public Ingrediente traerPorNombre(String nombre);
}
