package com.todocodeacademy.turnos.controller;

import com.todocodeacademy.turnos.dto.turnoDTO;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService service;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody turnoDTO turno){

        service.saveTurno(turno.getFecha(),turno.getTratamiento(),turno.getDniPaciente());

        return "Turno creado correctamente";
    }

    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return service.getTurnos();
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        service.deleteTurno(id);

        return "El turno fue eliminado correctamente";
    }

    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original,
                           @RequestBody Turno turnoEditar){

        service.editTurno(id_original,turnoEditar);

        Turno turnoEditado = service.findTurno(id_original);

        return turnoEditado;
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return service.findTurno(id);
    }
}
