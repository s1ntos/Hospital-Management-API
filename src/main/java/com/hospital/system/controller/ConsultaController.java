package com.hospital.system.controller;

import com.hospital.system.model.Consulta;
import com.hospital.system.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/agendar")
    public ResponseEntity<Consulta> agendar(@RequestParam Long idMedico,
                                            @RequestParam Long idPaciente,
                                            @RequestParam String dataHora) {
        LocalDateTime horario = LocalDateTime.parse(dataHora); // formato ISO: "2025-06-17T14:00"
        Consulta consulta = consultaService.agendarConsulta(idMedico, idPaciente, horario);
        return ResponseEntity.ok(consulta);
    }
}

