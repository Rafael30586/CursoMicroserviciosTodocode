package com.todocodeacademy.ingredientes.repository;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente,Long> {

    public Ingrediente findByNombreIngrediente(String nombreIngrediente);
}
