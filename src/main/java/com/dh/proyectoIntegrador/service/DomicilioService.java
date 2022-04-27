package com.dh.proyectoIntegrador.service;

import com.dh.proyectoIntegrador.entities.Domicilio;
import com.dh.proyectoIntegrador.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DomicilioService {

    @Autowired
    DomicilioRepository repoDomicilio;

    public List<Domicilio> listar(){
        return repoDomicilio.findAll();
    }

    public Optional<Domicilio> buscar(Long id){
        return repoDomicilio.findById(id);
    }

    public Domicilio agregar(Domicilio domicilio){
        return repoDomicilio.save(domicilio);
    }

    public Domicilio modificar(Domicilio domicilio) {
        if(buscar(domicilio.getId()).isPresent())
            return repoDomicilio.save(domicilio);
        else
            return null;
    }
    public void eliminar(Long id){
        repoDomicilio.deleteById(id);
    }
}
