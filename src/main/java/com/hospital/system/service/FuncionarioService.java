package com.hospital.system.service;

import com.hospital.system.model.Funcionario;
import com.hospital.system.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario ListarFuncionario(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario f = ListarFuncionario(id);
        if(f != null) {
            f.setNome(funcionario.getNome());
            f.setCargo(funcionario.getCargo());
            f.setEmail(funcionario.getEmail());
            f.setTelefone(funcionario.getTelefone());
            return funcionarioRepository.save(f);
        }
        return null;
    }

    public boolean deletarFuncionario(Long id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
