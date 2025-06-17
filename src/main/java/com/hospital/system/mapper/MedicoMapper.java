package com.hospital.system.mapper;

import com.hospital.system.dto.MedicoResponseDTO;
import com.hospital.system.model.Medico;

public class MedicoMapper {

    public static MedicoResponseDTO toDTO(Medico medico) {
        MedicoResponseDTO dto = new MedicoResponseDTO();
        dto.setNome(medico.getNome());
        dto.setEspecialidade(medico.getEspecialidade());
        return dto;
    }
}
