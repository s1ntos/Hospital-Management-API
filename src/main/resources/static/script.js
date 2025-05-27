document.getElementById("formPaciente").addEventListener("submit", async function (e) {
    e.preventDefault();

    const paciente = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        planoSaude: document.getElementById("planoSaude").value,
        dataNascimento: document.getElementById("dataNascimento").value
    };

    await fetch("http://localhost:8080/pacientes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(paciente)
    });

    listarPacientes();
});

async function listarPacientes() {
    const res = await fetch("http://localhost:8080/pacientes");
    const pacientes = await res.json();

    const ul = document.getElementById("listaPacientes");
    ul.innerHTML = "";
    pacientes.forEach(p => {
        const li = document.createElement("li");
        li.textContent = `${p.nome} - ${p.cpf}`;
        ul.appendChild(li);
    });
}

listarPacientes();
