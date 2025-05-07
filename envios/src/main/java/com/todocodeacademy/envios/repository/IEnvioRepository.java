package com.todocodeacademy.envios.repository;

import com.todocodeacademy.envios.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnvioRepository extends JpaRepository<Envio,Long> {
}
