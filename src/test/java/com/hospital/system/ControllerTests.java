package com.hospital.system;


import com.hospital.system.model.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ControllerTests extends BaseControllerTest{

    @Test
    public void deveCriarPaciente() throws Exception {
        Paciente p = new Paciente();
        p.setNome("Pacientest");
        p.setCpf("0000001");
        p.setPlanoSaude("test");

        executarPost("/api/pacientes", p)
                .andExpect(status().isCreated());
    }
}
