package com.dh.proyectoIntegrador.controller;

import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OdontologoController {
    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public List<Odontologo> listarOdontologos(){
        return odontologoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id){
        if(odontologoService.buscar(id).isPresent()){
            return ResponseEntity.ok(odontologoService.buscar(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.agregar(odontologo);
    }

    @PutMapping
    public Odontologo modificarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.modificar(odontologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {

        try{
            odontologoService.eliminar(id);
        }catch(Exception e){
            logger.error(e);
        }

        return ResponseEntity.ok("Se elimino el odontologo correctamente");
    }
}
