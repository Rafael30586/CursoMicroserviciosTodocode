package com.todocodeacademy.pacientes.service;

import com.todocodeacademy.pacientes.model.Paciente;
import com.todocodeacademy.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository repository;

    @Override
    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    @Override
    public void savePaciente(Paciente paciente) {
        repository.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void editPaciente(Paciente paciente) {
        this.savePaciente(paciente);
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return repository.findByDni(dni);
    }
}
