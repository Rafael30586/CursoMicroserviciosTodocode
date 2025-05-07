package com.todocodeacademy.envios.service;

import com.todocodeacademy.envios.dto.DestinatarioDTO;
import com.todocodeacademy.envios.model.Envio;

import java.util.List;

public interface IEnvioService {

    public List<Envio> traerTodos();

    public void crear(Envio envio);

    public Envio modificar(Long id, Envio envio);

    public void eliminarPorId(Long id);

    public Envio traerPorId(Long id);

    public DestinatarioDTO traerDestinatario(Long idEnvio);

    public List<Envio> traerPorIdDestinatario(Long idDestinatario);
}
