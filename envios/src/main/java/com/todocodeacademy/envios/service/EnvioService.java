package com.todocodeacademy.envios.service;

import com.todocodeacademy.envios.dto.DestinatarioDTO;
import com.todocodeacademy.envios.model.Envio;
import com.todocodeacademy.envios.repository.IDestinatarioClient;
import com.todocodeacademy.envios.repository.IEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService implements IEnvioService{

    @Autowired
    private IEnvioRepository repository;
    @Autowired
    private IDestinatarioClient destinatarioClient;

    @Override
    public List<Envio> traerTodos() {
        return repository.findAll();
    }

    @Override
    public void crear(Envio envio) {
        repository.save(envio);
    }

    @Override
    public Envio modificar(Long id, Envio envio) {
        this.crear(envio);
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Envio traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public DestinatarioDTO traerDestinatario(Long idEnvio) {
        Long idDestinatario = repository.findById(idEnvio).get().getIdDestinatario();
        return destinatarioClient.traerPorId(idDestinatario);
    }

    @Override
    public List<Envio> traerPorIdDestinatario(Long idDestinatario) {
        return repository.findByIdDestinatario(idDestinatario);
    }
}
