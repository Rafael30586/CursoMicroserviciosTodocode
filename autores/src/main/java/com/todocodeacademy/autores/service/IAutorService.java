package com.todocodeacademy.autores.service;

import com.todocodeacademy.autores.model.Autor;

import java.util.List;

public interface IAutorService {

    public void crear(Autor autor);

    public List<Autor> traerTodos();

    public Autor encontrarPorId(Long id);

    public void eliminarPorId(Long id);

    public Autor editar(Long id,Autor autor);

    public Autor traerPorNombreYNacionalidad(String nombreCompleto, String nacionalidad);
}
