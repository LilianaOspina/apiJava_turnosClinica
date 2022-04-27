package com.dh.proyectoIntegrador.service;

import com.dh.proyectoIntegrador.entities.Turno;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repoTurno;
    //get
    public List<Turno> listar(){
        return repoTurno.findAll();
    }

    public Optional<Turno> buscar(Long id){
        return repoTurno.findById(id);
    }
    //post
    public Turno registrar(Turno turno){
        return repoTurno.save(turno);
    }
    //put
    public Turno modificar(Turno turno) {
        if(buscar(turno.getId()).isPresent())
            return repoTurno.save(turno);
        else
            return null;
    }
    //delete
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado= buscar(id);
        if (turnoBuscado.isPresent())
            repoTurno.deleteById(id);
        else
            throw new ResourceNotFoundException("No se encontro el turno con id"+id+". Intente de nuevo");
    }

}
