# 🏥 Hospital Management System

Este é um projeto de sistema hospitalar com uma **API RESTful em Spring Boot** e um **front-end simples em HTML + JavaScript**, criado com foco em aprendizado de arquitetura em camadas e integração com front-end.

![status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
---

## 🎯 Objetivo

Permitir o cadastro e listagem de pacientes, e servir como base para desenvolvimento de funcionalidades mais complexas, como gerenciamento de atendimentos, internações, médicos e históricos clínicos.

---

## ✅ Funcionalidades

- Cadastro de pacientes (nome, CPF, plano de saúde, data de nascimento)
- Listagem de pacientes em tempo real no front-end
- Integração front-end ↔️ back-end usando `fetch API`
- Arquitetura organizada (Controller → Service → Repository)

📅 Consultas
Agendamento de consulta (POST /api/consultas/agendar)

Usando AgendamentoConsultaDTO

Valida se:
  Médico e paciente existem
  Horário não está no passado
  Médico não tem outra consulta no mesmo horário
  Listagem de todas as consultas (GET /api/consultas)
---

## 🚧 Desafio em andamento

### resolver problemas na coneção do frontend com o backend
### Endpoint a ser desenvolvido:

GET /api/pacientes/{id}/historico

Este endpoint deverá retornar os **atendimentos** e **internações** associados ao paciente pelo seu ID.

### Tarefas pendentes:

- Criar as entidades `Atendimento` e `Internacao`
- Mapear corretamente os relacionamentos com `Paciente`
- Implementar a lógica no `Service` e `Controller`
- Retornar os dados no formato JSON

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- HTML5 + CSS3 + JavaScript
- Live Server (VS Code)

## 🗂️ Estrutura do Projeto (BACKEND)

 HOSPITALSYSTEMAPI/
```
HOSPITAL-API/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── hospital/
│                   └── system/
│                       ├── controller/
│                       │   ├── ConsultaController.java
│                       │   ├── MedicoController.java
│                       │   └── PacienteController.java
│                       ├── dto/
│                       │   ├── AgendamentoConsultaDTO.java
│                       │   ├── MedicoResponseDTO.java
│                       │   └── PacienteResponseDTO.java
│                       ├── exception/
│                       │   └── RegraDeNegocioException.java
│                       ├── mapper/
│                       │   ├── MedicoMapper.java
│                       │   └── PacienteMapper.java
│                       ├── model/
│                       │   ├── Consulta.java
│                       │   ├── Medico.java
│                       │   └── Paciente.java
│                       ├── repository/
│                       │   ├── ConsultaRepository.java
│                       │   ├── MedicoRepository.java
│                       │   └── PacienteRepository.java
│                       ├── service/
│                       │   ├── ConsultaService.java
│                       │   ├── MedicoService.java
│                       │   └── PacienteService.java
│                       └── SystemApplication.java

```

## 📊 Diagrama de Classes
![Diagrama de Classes](docs/diagrama-classes.PNG)


## ✍️ Autor
Em desenvolvimento por João Paulo como parte de um desafio prático para consolidar conhecimentos em Spring Boot e desenvolvimento web full-stack.

