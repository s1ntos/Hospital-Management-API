package com.hospital.system.service;

import com.hospital.system.exception.RegraDeNegocioException;
import com.hospital.system.model.Consulta;
import com.hospital.system.model.Medico;
import com.hospital.system.model.Paciente;
import com.hospital.system.repository.ConsultaRepository;
import com.hospital.system.repository.MedicoRepository;
import com.hospital.system.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta agendarConsulta(Long idMedico, Long idPaciente, LocalDateTime dataHora, String descricao) {

        Medico medico = medicoRepository.findById(idMedico)
                .orElseThrow(() -> new RegraDeNegocioException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RegraDeNegocioException("Paciente não encontrado"));


        if (consultaRepository.existsByMedicoAndDataHora(medico, dataHora)) {
            throw new RegraDeNegocioException("Este horário já está ocupado para o médico selecionado");
        }

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dataHora);
        consulta.setDescricao(descricao);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta listarConsulta(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta atualizarConsulta(Long id, Consulta Consulta) {
        Consulta consulta = listarConsulta(id);
        if(consulta != null) {
            consulta.setMedico(Consulta.getMedico());
            consulta.setPaciente(Consulta.getPaciente());
            consulta.setDataHora(Consulta.getDataHora());
            consulta.setDescricao(consulta.getDescricao());
            return consultaRepository.save(consulta);
        }
        return null;
    }

    public boolean deletarConsulta(Long id) {
        if(consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}


