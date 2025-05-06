package com.todocodeacademy.autores.repository;

import com.todocodeacademy.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends JpaRepository<Autor,Long> {

    public Autor findByNombreCompletoAndNacionalidad(String nombreCompleto, String nacionalidad);
}
