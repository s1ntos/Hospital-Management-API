package com.hospital.system.controller;

import com.hospital.system.dto.PacienteResponseDTO;
import com.hospital.system.mapper.PacienteMapper;
import com.hospital.system.model.Paciente;
import com.hospital.system.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://127.0.0.1:5500/p1.html")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody @Valid Paciente paciente) {
        Paciente salvo = pacienteService.salvarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }


    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listarPaciente() {
        List<PacienteResponseDTO> pacientes = pacienteService.listarPaciente();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarporid(id);
        if(paciente != null) {
            return ResponseEntity.ok(paciente);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, Paciente paciente) {
        Paciente att = pacienteService.atualizar(id, paciente);
        if(att == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(att);
    }

    @DeleteMapping
    public ResponseEntity<Paciente> deletarPaciente(@PathVariable long id) {
        boolean deletado = pacienteService.deletarpaciente(id);
        return deletado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
