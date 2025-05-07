package com.todocodeacademy.envios.repository;

import com.todocodeacademy.envios.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnvioRepository extends JpaRepository<Envio,Long> {

    public List<Envio> findByIdDestinatario(Long idDestinatario);
}
