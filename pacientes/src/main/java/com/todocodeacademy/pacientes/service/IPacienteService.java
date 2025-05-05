package com.todocodeacademy.pacientes.service;

import com.todocodeacademy.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {

    public List<Paciente> getPacientes();

    public void savePaciente(Paciente paciente);

    public void deletePaciente(Long id);

    public Paciente findPaciente(Long id);

    public void editPaciente(Paciente paciente);

    public Paciente findPacienteDni(String dni);
}
