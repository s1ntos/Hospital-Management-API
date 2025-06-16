package com.hospital.system.repository;

import com.hospital.system.model.Consulta;
import com.hospital.system.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoAndDataHora(Medico medico, LocalDateTime dataHora);
}
