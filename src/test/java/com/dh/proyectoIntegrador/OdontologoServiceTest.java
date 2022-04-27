package com.dh.proyectoIntegrador;

import com.dh.proyectoIntegrador.entities.Domicilio;
import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.OdontologoService;
import com.dh.proyectoIntegrador.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    public void cargarDatos(){
        odontologoService.agregar(
            new Odontologo(
                "abc123",
                "Elena",
                "Urda"
        ));
    }

    //get
    @Test
    public void d_listarOdontologoTest(){
        Assert.assertNotNull(odontologoService.listar());
    }

    @Test
    public void b_buscarOdontologoTest(){
        Assert.assertNotNull(odontologoService.buscar(1L));
    }

    //post
    @Test
    public void a_agregarOdontologoTest(){
        this.cargarDatos();
        Odontologo odontologo = odontologoService.agregar(
                new Odontologo(
                        "dfg456",
                        "Tom",
                        "Velvedere"
                )
        );
        Assert.assertNotNull(odontologo);
    }

    //PUT ===========actualizar
    @Test
    public void c_modificarOdontologoTest(){
        Odontologo odontologo = odontologoService.agregar(
            new Odontologo(
                "dfg456",
                "Tom",
                "Velvedere"

            )
        );
        Assert.assertEquals("Tom",odontologo.getNombre());
    }

    //DELETE
    @Test
    public void e_eliminarOdontologoTest() throws ResourceNotFoundException {
        odontologoService.eliminar(1L);
        Assert.assertFalse(odontologoService.buscar(1L).isPresent());
    }
}
