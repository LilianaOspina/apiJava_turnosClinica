package com.dh.proyectoIntegrador;

import com.dh.proyectoIntegrador.entities.Domicilio;
import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.entities.Turno;
import com.dh.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.dh.proyectoIntegrador.service.OdontologoService;
import com.dh.proyectoIntegrador.service.PacienteService;
import com.dh.proyectoIntegrador.service.TurnoService;
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
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

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
                        LocalDate.of(2022,04,01),
                        domicilio)
        );
        this.odontologoService.agregar(
                new Odontologo(
                        "abc123",
                        "Silvia",
                        "Urda")
        );
    }
    //get
    @Test
    public void d_listarTurnoTest() {
        Assert.assertNotNull(turnoService.listar());
    }

    @Test
    public void b_buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1L));
    }

    //post
    @Test
    public void a_registroTurnoTest(){
        this.cargarDatos();
        Turno turno = turnoService.registrar(new Turno(
            pacienteService.buscar(1L).get(),
            odontologoService.buscar(1L).get(),
            LocalDate.of(2022,06,10)));
        Assert.assertNotNull(turno);
    }
    //put
    @Test
    public void c_modificarTurnoTest(){
        Turno turno = turnoService.modificar(
                new Turno(
                    1L,
                    pacienteService.buscar(1L).get(),
                    odontologoService.buscar(1L).get(),
                    LocalDate.of(2022,10,1)
        ));
        Assert.assertEquals(
                LocalDate.of(2022,10,1),turno.getFecha()
        );
    }
    //delete
    @Test
    public void e_eliminarTurnoTest() throws ResourceNotFoundException {
        turnoService.eliminar(1L);
        Assert.assertFalse(turnoService.buscar(1L).isPresent());
    }
}
