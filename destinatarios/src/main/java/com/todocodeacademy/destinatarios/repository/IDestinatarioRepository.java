package com.todocodeacademy.destinatarios.repository;

import com.todocodeacademy.destinatarios.model.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDestinatarioRepository extends JpaRepository<Destinatario, Long> {
}
