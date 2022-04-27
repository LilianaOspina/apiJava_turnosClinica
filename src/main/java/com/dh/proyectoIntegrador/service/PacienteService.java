package com.dh.proyectoIntegrador.service;

import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repoPaciente;

    //GET
    public List<Paciente> listar() {
        return repoPaciente.findAll();
    }
    public Optional<Paciente> buscar(Long id) {
        return repoPaciente.findById(id);
    }
    //POST
    public Paciente agregar(Paciente paciente) {
        return repoPaciente.save(paciente);
    }
    //PUT
    public Paciente modificar(Paciente paciente) {
        if(buscar(paciente.getId()).isPresent())
            return repoPaciente.save(paciente);
        else
            return null;
    }
    //DELETE
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = buscar(id);
        if(pacienteBuscado.isPresent())
            repoPaciente.deleteById(id);
        else
            throw new ResourceNotFoundException(
                    "No se encontro el paciente con id"+id+". Intente de nuevo"
            );
    }
}
