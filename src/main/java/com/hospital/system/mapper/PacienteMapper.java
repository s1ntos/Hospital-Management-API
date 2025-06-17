package com.hospital.system.mapper;

import com.hospital.system.dto.PacienteResponseDTO;
import com.hospital.system.model.Paciente;

public class PacienteMapper {

    public static PacienteResponseDTO toDTO(Paciente paciente) {
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setPlanoSaude(paciente.getPlanoSaude());
        return dto;
    }
}
