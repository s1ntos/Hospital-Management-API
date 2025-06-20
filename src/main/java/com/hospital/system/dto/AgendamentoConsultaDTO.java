package com.hospital.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AgendamentoConsultaDTO {

    private Long medico;
    private Long paciente;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String dataHora;

    private String descricao;

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
