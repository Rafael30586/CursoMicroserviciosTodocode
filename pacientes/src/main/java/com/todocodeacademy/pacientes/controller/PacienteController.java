package com.todocodeacademy.pacientes.controller;

import com.todocodeacademy.pacientes.model.Paciente;
import com.todocodeacademy.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @PostMapping("/pacientes/crear")
    public String crearCurso(@RequestBody Paciente paciente){
        service.savePaciente(paciente);
        return "Paciente creado correctamente";
    }

    @GetMapping("/pacientes/traer")
    public List<Paciente> traerPacientes(){
        return service.getPacientes();
    }

    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        service.deletePaciente(id);
        return "Paciente borrado correctamente";
    }

    @PutMapping("/pacientes/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                                 @RequestBody Paciente pacienteEditar){

        service.editPaciente(pacienteEditar); //Esta parte del ejercicio no está clara, tuve que cambiar levemente el código
        Paciente pacienteEditado = service.findPaciente(id_original);

        return pacienteEditado;
    }

    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){

        return service.findPacienteDni(dni);
    }
}
