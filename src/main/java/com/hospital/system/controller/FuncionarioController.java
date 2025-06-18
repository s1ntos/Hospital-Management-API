package com.hospital.system.controller;

import com.hospital.system.model.Funcionario;
import com.hospital.system.model.Medico;
import com.hospital.system.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Funcionarios")
@CrossOrigin(origins = "http://127.0.0.1:5500/p1.html")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> criar (@RequestBody Funcionario funcionario ){
        Funcionario func = funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(func);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> func = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(func);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> listarFuncionario(@PathVariable Long id) {
        Funcionario func = funcionarioService.ListarFuncionario(id);
        if(func == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(func);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        Funcionario func = funcionarioService.atualizarFuncionario(id, funcionario);
        if(func == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(func);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletarmedico(@PathVariable Long id) {
        boolean func = funcionarioService.deletarFuncionario(id);
        return func ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

