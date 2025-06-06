package com.hospital.system.service;

import com.hospital.system.model.Medico;
import com.hospital.system.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico salvarmedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarmedico() {
        return medicoRepository.findAll();
    }

    public Medico buscarmedicoporid(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public Medico atualizarmedico(Long id, Medico dados) {
        Medico medico = buscarmedicoporid(id);
        if(medico != null) {
            medico.setNome(dados.getNome());
            medico.setCrm(dados.getCrm());
            medico.setEspecialidade(dados.getEspecialidade());
            return medicoRepository.save(medico);
        }
        return null;
    }

    public boolean deletarmedico(Long id) {
        if(medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
