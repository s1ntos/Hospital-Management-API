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

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta agendarConsulta(Long idMedico, Long idPaciente, LocalDateTime dataHora) {

        Medico medico = medicoRepository.findById(idMedico)
                .orElseThrow(() -> new RegraDeNegocioException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RegraDeNegocioException("Paciente não encontrado"));

        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new RegraDeNegocioException("Não é possível agendar para o passado");
        }

        if (consultaRepository.existsByMedicoAndDataHora(medico, dataHora)) {
            throw new RegraDeNegocioException("Este horário já está ocupado para o médico selecionado");
        }

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dataHora);
        consulta.setStatus(com.hospital.system.model.StatusConsulta.AGENDADA);

        return consultaRepository.save(consulta);
    }
}

