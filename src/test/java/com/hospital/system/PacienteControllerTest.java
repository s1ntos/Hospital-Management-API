package com.hospital.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.system.repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        funcionarioRepository.deleteAll();
    }

    @Test
    public void deveCriarFuncionario() throws Exception {
        String funcionarioJson = """ 
        {
          "nome": "João Teste",
          "cargo": "enfermeiro",
          "emaiil": "joao@teste.com",
          "telefone": 945768935
        }""";

        mockMvc.perform(post("/api/Funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(funcionarioJson))
                .andExpect(status().isCreated());
    }
}
