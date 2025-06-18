## 📂 Estrutura de Testes

Os testes são organizados por entidade e utilizam métodos genéricos para reaproveitamento de código (POST, GET, PUT, DELETE).

### 📌 Exemplo de Uso

#### 🔹 POST - Criar recursos
```java
executarPost("/api/medicos", medicoDTO)
    .andExpect(status().isCreated());
```
#### 🔹 PUT - atualizar recursos
```java
executarPost("/api/medicos", medicoDTO)
    .andExpect(status().isCreated());
```
#### 🔹 GET - listar recursos
```java
executarPost("/api/medicos", medicoDTO)
    .andExpect(status().isCreated());
```
#### 🔹 DELETE - deletar recursos
```java
executarPost("/api/medicos", medicoDTO)
    .andExpect(status().isCreated());
```