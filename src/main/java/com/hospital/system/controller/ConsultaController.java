package com.hospital.system.controller;

import com.hospital.system.dto.AgendamentoConsultaDTO;
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
    public ResponseEntity<Consulta> agendar(@RequestBody AgendamentoConsultaDTO dto) {
        LocalDateTime horario = LocalDateTime.parse(dto.dataHora);
        Consulta consulta = consultaService.agendarConsulta(dto.medico, dto.paciente, horario);
        return ResponseEntity.ok(consulta);
    }

}

