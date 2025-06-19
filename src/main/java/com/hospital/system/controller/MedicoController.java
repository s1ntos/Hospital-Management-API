package com.hospital.system.controller;

import com.hospital.system.dto.MedicoResponseDTO;
import com.hospital.system.model.Medico;
import com.hospital.system.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "http://127.0.0.1:5500/p1.html")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> criar(@RequestBody @Valid Medico medico){
        Medico med = medicoService.salvarmedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(med);
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar(){
        List<MedicoResponseDTO> med = medicoService.listarMedico();
        return ResponseEntity.ok(med);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarMedico(@PathVariable  Long id) {
        Medico buscar = medicoService.buscarmedicoporid(id);
        if(buscar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizar(@PathVariable  Long id, @RequestBody @Valid Medico medico) {
        Medico att = medicoService.atualizarmedico(id, medico);
        if(att == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(att);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medico> deletarmedico(@PathVariable Long id) {
        boolean meddeleted = medicoService.deletarmedico(id);
        return meddeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
