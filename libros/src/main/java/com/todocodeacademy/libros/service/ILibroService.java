package com.todocodeacademy.libros.service;

import com.todocodeacademy.libros.model.Libro;

import java.util.List;

public interface ILibroService {

    public void crear(Libro libro);

    public List<Libro> traerTodos();

    public Libro traerPorIsbn(String isbn);

    public void eliminarPorIsbn(String isbn);

    public Libro editar(String isbn, Libro libro);
}
