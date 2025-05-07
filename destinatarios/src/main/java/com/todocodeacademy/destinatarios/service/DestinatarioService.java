package com.todocodeacademy.destinatarios.service;

import com.todocodeacademy.destinatarios.model.Destinatario;
import com.todocodeacademy.destinatarios.repository.IDestinatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinatarioService implements IDestinatarioService{

    @Autowired
    private IDestinatarioRepository repository;


    @Override
    public List<Destinatario> traerTodos() {
        return repository.findAll();
    }

    @Override
    public Destinatario traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Destinatario modificar(Long id, Destinatario destinatario) {
        this.crear(destinatario);
        return repository.findById(id).get();
    }

    @Override
    public void crear(Destinatario destinatario) {
        repository.save(destinatario);
    }
}
