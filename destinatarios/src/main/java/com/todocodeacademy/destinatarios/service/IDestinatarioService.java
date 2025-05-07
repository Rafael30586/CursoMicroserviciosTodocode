package com.todocodeacademy.destinatarios.service;

import com.todocodeacademy.destinatarios.dto.EnvioDTO;
import com.todocodeacademy.destinatarios.model.Destinatario;

import java.util.List;

public interface IDestinatarioService {

    public List<Destinatario> traerTodos();

    public Destinatario traerPorId(Long id);

    public void eliminarPorId(Long id);

    public Destinatario modificar(Long id, Destinatario destinatario);

    public void crear(Destinatario destinatario);

    public List<EnvioDTO> traerEnviosPorDestinatario(Long idDestinatario);
}
