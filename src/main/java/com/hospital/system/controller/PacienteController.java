package com.hospital.system.controller;

import com.hospital.system.model.Paciente;
import com.hospital.system.repository.PacienteRepository;
import com.hospital.system.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.salvarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Paciente> listarPaciente() {
        return pacienteService.listarPaciente();
    }

    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarporid(id);
        if(paciente != null) {
            return ResponseEntity.ok(paciente);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, Paciente paciente) {
        Paciente att = pacienteService.atualizar(id, paciente);
        if(att == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(att);
    }

    public ResponseEntity<Paciente> deletarPaciente(@PathVariable long id) {
        boolean deletado = pacienteService.deletarpaciente(id);
        return deletado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
