package com.todocodeacademy.turnos.service;


import com.todocodeacademy.turnos.model.Paciente;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository repository;

    @Autowired
    private RestTemplate apiConsumir;//Debe tener el mismo nombre que tiene en la clase appConfig


    @Override
    public List<Turno> getTurnos() {
        return repository.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {


        //Paciente paciente = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        Paciente paciente = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        String nombreCompletoPaciente = paciente.getNombre()+" "+paciente.getApellido(); //Paciente.class hace referencia al nombre...
        //...de la clase  que devuelve la solicitud


        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        repository.save(turno);

    }

    @Override
    public void deleteTurno(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Turno findTurno(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void editTurno(Long id, Turno turno) {

        Turno turno2 = this.findTurno(id);

        turno2.setFecha(turno.getFecha());
        turno2.setTratamiento(turno.getTratamiento());
        turno2.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        repository.save(turno2);

    }
}
