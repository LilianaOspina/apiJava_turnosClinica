package com.dh.proyectoIntegrador;

import com.dh.proyectoIntegrador.entities.Domicilio;
import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    public void cargarDatos(){
        Domicilio domicilio = new Domicilio(
                "Bustillo",
                16000,
                "Bariloche",
                "Rio Negro"
        );
        Paciente paciente = pacienteService.agregar(
                new Paciente(
                        "Chennales",
                        "Leandro",
                        "lean@gmail.com",
                        565683,
                        LocalDate.of(2022,4,1),
                        domicilio)
        );
    }

    @Test
    public void d_listarPacienteTest(){
        Assert.assertNotNull(pacienteService.listar());
    }

    @Test
    public void b_buscarPacienteTest(){
        Assert.assertNotNull(pacienteService.buscar(1L));
    }

    @Test
    public void a_agregarPacienteTest(){
        this.cargarDatos();
        Domicilio domicilio = new Domicilio(
                "Cervino",
                4747,
                "CABA",
                "CABA"
        );
        Paciente paciente = pacienteService.agregar(
                new Paciente(
                        "Ospina",
                        "Tom",
                        "tom@gmail.com",
                        565683,
                        LocalDate.of(2022,4,1),
                        domicilio)
        );
        Assert.assertNotNull(paciente);
    }

    @Test
    public void c_modificarPacienteTest(){
        Domicilio domicilio = new Domicilio(
            "Cervino",
            4747,
            "CABA",
            "CABA"
        );
        Paciente paciente = new Paciente(
            "Chennales",
            "Tom",
            "tom@gmail.com",
            565683,
            LocalDate.of(2022,11,1),
            domicilio
        );
        Assert.assertEquals(
            LocalDate.of(2022,11,1),paciente.getFechaIngreso());
    }

    @Test
    public void e_eliminarPacienteTest() throws ResourceNotFoundException {
        pacienteService.eliminar(1L);
        Assert.assertFalse(pacienteService.buscar(1L).isPresent());
    }
}
