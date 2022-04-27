package com.dh.proyectoIntegrador.controller;

import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.entities.Turno;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.OdontologoService;
import com.dh.proyectoIntegrador.service.PacienteService;
import com.dh.proyectoIntegrador.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TurnoController {

    private static final Logger logger = Logger.getLogger(TurnoController.class);

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    //Listar todos; esto devuelve json
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        //Devuelve código 200
        return ResponseEntity.ok(turnoService.listar());
    }

    //Buscar Por id
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){
        if(turnoService.buscar(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscar(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){

        ResponseEntity<Turno> respuesta;

        //controlar si los id son existentes
        Optional<Paciente> paciente= pacienteService.buscar(turno.getPaciente().getId());
        Optional<Odontologo> odontologo= odontologoService.buscar(turno.getOdontologo().getId());

        if (paciente.isPresent()&&odontologo.isPresent()){
            respuesta=ResponseEntity.ok(turnoService.registrar(turno));
        }
        else{
            respuesta= ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @PutMapping
    public Turno modificarTurno(@RequestBody Turno turno){
        return turnoService.modificar(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            turnoService.eliminar(id);
        }catch(Exception e){
            logger.error(e);
        }
        return ResponseEntity.ok("Se elimino correctamente el turno");
    }
}
