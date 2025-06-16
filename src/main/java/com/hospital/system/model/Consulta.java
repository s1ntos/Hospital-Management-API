package com.hospital.system.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;

    private LocalDateTime datahora;

    @Enumerated(EnumType.STRING)
    private String status;
}
