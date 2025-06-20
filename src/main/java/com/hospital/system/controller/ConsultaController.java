package com.hospital.system.controller;

import com.hospital.system.dto.AgendamentoConsultaDTO;
import com.hospital.system.model.Consulta;
import com.hospital.system.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "http://127.0.0.1:5500/p1.html")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/agendar")
    public ResponseEntity<Consulta> agendar(@RequestBody @Valid AgendamentoConsultaDTO dto) {
        LocalDateTime horario = LocalDateTime.parse(dto.getDataHora());
        Consulta consulta = consultaService.agendarConsulta(dto.getMedico(), dto.getPaciente(), horario);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity <List<Consulta>> listar() {
        List<Consulta> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> listarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        Consulta cons = consultaService.listarConsulta(id);
        if(cons == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cons);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consulta> deletarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        boolean cons = consultaService.deletarConsulta(id);
        return cons ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }


}


