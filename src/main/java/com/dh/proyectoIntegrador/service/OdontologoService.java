package com.dh.proyectoIntegrador.service;

import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService{

    @Autowired
    private OdontologoRepository repoOdontologo;

    public List<Odontologo> listar(){
        return repoOdontologo.findAll();
    }

    public Optional<Odontologo> buscar(Long id){
        return repoOdontologo.findById(id);
    }

    public Odontologo agregar(Odontologo odontologo){
        return repoOdontologo.save(odontologo);
    }

    public Odontologo modificar(Odontologo odontologo) {
        if(buscar(odontologo.getId()).isPresent())
            return repoOdontologo.save(odontologo);
        else
            return null;
    }
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = buscar(id);
        if (odontologoBuscado.isPresent())
            repoOdontologo.deleteById(id);
        else
            throw new ResourceNotFoundException(
                    "No se encontro el odontologo con id"+id+". Intente de nuevo"
            );
    }

}
