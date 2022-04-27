package com.dh.proyectoIntegrador.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //La relacion con las pacientes es de muchos turnos a un paciente
    @ManyToOne(fetch = FetchType.EAGER)
    //nombramos la foreign key paciente id; no deberian ser nulos entonces agregamos ese detalle que no puedan ser null
    @JoinColumn(name="paciente_id",nullable = false)
    private Paciente paciente;

    //La relacion con las pacientes es de muchos turnos a un paciente
    @ManyToOne(fetch = FetchType.EAGER)
    //nombramos la foreign key paciente id
    @JoinColumn(name="odontologo_id",nullable = false)
    private Odontologo odontologo;

    private LocalDate fecha;

    public Turno(){

    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    //Para probar el test
    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
