package com.dh.proyectoIntegrador;


import com.dh.proyectoIntegrador.entities.Domicilio;
import com.dh.proyectoIntegrador.entities.Odontologo;
import com.dh.proyectoIntegrador.entities.Paciente;
import com.dh.proyectoIntegrador.entities.Turno;
import com.dh.proyectoIntegrador.service.OdontologoService;
import com.dh.proyectoIntegrador.service.PacienteService;
import com.dh.proyectoIntegrador.service.TurnoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    TurnoService turnoService;

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
        odontologoService.agregar(
                new Odontologo(
                        "abc123",
                        "Silvia",
                        "Urda")
                );
        turnoService.registrar(
            new Turno(
                pacienteService.buscar(1L).get(),
                odontologoService.buscar(1L).get(),
                LocalDate.of(2022,06,10)
            )
        );
    }

    //Probamos los controller
    @Test
    public void listarTurnos() throws Exception {
        this.cargarDatos();
        MvcResult respuesta= mockMvc.perform(MockMvcRequestBuilders.get("/turnos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
    //Para Post

    //Para put

    //Para Delete

    //Para path variable

    //:...(
}
