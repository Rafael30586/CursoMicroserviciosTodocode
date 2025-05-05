package com.todocodeacademy.platos.service;

import com.todocodeacademy.platos.model.Ingrediente;
import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlatoService implements IPlatoService{

    @Autowired
    private IPlatoRepository repository;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public void crear(Plato plato) {
        List<String> ingredientes = plato.getLista_ingredientes();
        for(String i : ingredientes){
            HttpEntity<Ingrediente> solicitud = new HttpEntity<>(new Ingrediente(i));
            /*Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombreIngrediente(i);*/
            if(apiConsumir.getForObject("http://localhost:9001/ingredientes/por-nombre/"+i,Ingrediente.class)==null) {
                apiConsumir.postForObject("http://localhost:9001/ingredientes/", solicitud, Ingrediente.class);
            }
        }
        repository.save(plato);
    }

    @Override
    public List<Plato> traerTodos() {
        return repository.findAll();
    }

    @Override
    public Plato traerPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Plato editar(Long id, Plato plato) {
        this.crear(plato);
        return repository.findById(id).get();
    }
}
