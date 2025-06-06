package com.hospital.system.service;

import com.hospital.system.model.Paciente;
import com.hospital.system.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPaciente() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarporid(long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente atualizar(Long id, Paciente dados) {
        Paciente paciente = buscarporid(id);
        if(paciente != null) {
            paciente.setId(id);
            paciente.setNome(dados.getNome());
            paciente.setCpf(dados.getCpf());
            paciente.setPlanoSaude(dados.getPlanoSaude());
            paciente.setDataNascimento(dados.getDataNascimento());
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public boolean deletarpaciente(long id) {
        if(pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
