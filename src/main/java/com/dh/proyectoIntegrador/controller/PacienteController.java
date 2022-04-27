package com.dh.proyectoIntegrador.controller;

import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id){
        if(pacienteService.buscar(id).isPresent()){
            return ResponseEntity.ok(pacienteService.buscar(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public Paciente agregarPaciente(@RequestBody Paciente paciente){
        return pacienteService.agregar(paciente);
    }

    @PutMapping
    public Paciente modificarPaciente(@RequestBody Paciente paciente){
        return pacienteService.modificar(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            pacienteService.eliminar(id);
        }catch(Exception e){
            logger.error(e);
        }
        return ResponseEntity.ok("Se elimino correctamente el paciente");
    }
}
