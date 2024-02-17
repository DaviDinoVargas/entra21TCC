async function preenchePorCpf() {
    const Icpf = document.querySelector("#cpf");
    let Ncpf = Icpf.value

    let url = await fetch(`http://localhost:8080/auth/pacientes/cpf/${Ncpf}`)

    let response = await url.json()
    document.getElementById('nome').value = response.nome_paciente
    document.getElementById('id').value = response.id_paciente
}

// async function buscaId() {
//     const Icpf = document.querySelector("#cpf");
//     let cpf = Icpf.value
//     await fetch(`http://localhost:8080/auth/pacientes/cpf/${cpf}`)
//         .then(data => {

//             console.log(data);

//             //const resultadoConsulta = document.getElementById('resultadoConsulta');

//             if (data.id_paciente) {
//                 console.log(`ID do paciente: ${data.id_paciente}`);
//                 //localStorage.setItem('idPacEscala', data.id_paciente);

//             }
//         })
// }

async function preenchePorNome() {
    const Inome = document.getElementById("medico");
    let nome = Inome.value

    let url = await fetch(`http://localhost:8080/auth/medicos/nome/${nome}`)

    let response = await url.json()
    document.getElementById('idMed').value = response.id_medico
}
async function preenchePorNomeC() {
    const Inome = document.getElementById("cavalo");
    let nome = Inome.value

    let url = await fetch(`http://localhost:8080/auth/cavalos/nome/${nome}`)

    let response = await url.json()
    document.getElementById('idCav').value = response.id_cavalo
}




/*document.querySelector('#qtd_medicos').addEventListener('input', function (e) {
    const qtdMedicos = parseInt(e.target.value);
    const inputsMedicosDiv = document.getElementById('inputs_medicos');
    inputsMedicosDiv.innerHTML = '';
    for (let i = 0; i < qtdMedicos; i++) {
        const label = document.createElement('label');
        label.textContent = `Medico_${i + 1}:`;
        const input = document.createElement('input');
        input.type = 'text';
        input.name = `medico_${i + 1}`;
        input.id = `medico_${i + 1}`
        inputsMedicosDiv.appendChild(label);
        inputsMedicosDiv.appendChild(input);
        inputsMedicosDiv.appendChild(document.createElement('br'));
    }
});*/

document.querySelector('#qtd_instrutores').addEventListener('input', function (e) {
    const qtdInstrutores = parseInt(e.target.value);
    const inputsInstrutoresDiv = document.getElementById('inputs_instrutores');
    inputsInstrutoresDiv.innerHTML = '';
    for (let i = 0; i < qtdInstrutores; i++) {
        const label = document.createElement('label');
        label.textContent = `Instrutor ${i + 1}:`;
        const input = document.createElement('input');
        input.type = 'text';
        input.name = `instrutor_${i + 1}`;
        input.id = `instrutor_${i + 1}`
        inputsInstrutoresDiv.appendChild(label);
        inputsInstrutoresDiv.appendChild(input);
        inputsInstrutoresDiv.appendChild(document.createElement('br'));
    }
});
const formulario = document.querySelector("form");
const Iid = document.querySelector("#id");
const cavalo = document.querySelector("#idCav");
const Ihora = document.querySelector("#hora")
const Idata = document.querySelector("#idata")
const Iencilhameno = document.querySelector(".encilhamento")
const Isaude = document.querySelector(".condicao_saude")
const Imedico = document.querySelector("#idMed")
const Iinstrutor = document.querySelector("#instrutor_1")
const Icep = document.querySelector(".cep");
const Irua = document.querySelector(".rua");
const Ibairro = document.querySelector(".bairro");
const Icidade = document.querySelector(".cidadeC");
const Iuf = document.querySelector(".uf");
const Icomplemento = document.querySelector(".complemento");
const Inumero = document.querySelector(".numero");
const pais = "brasil"

function salvar() {
    const dados = {
        hora: Ihora.value,
        dataAvaliacao: Idata.value,
        encilhamento: Iencilhameno.value,
        condicaoSaude: Isaude.value,
        local: {
            cep: Icep.value,
            rua: Irua.value,
            cidade: Icidade.value,
            uf: Iuf.value,
            numero: Inumero.value,
        },
        paciente: {
            id_paciente: Iid.value
        },
        medico:{
            id_medico: Imedico.value
        },
        cavalo: {
            id_cavalo: cavalo.value
        }

    }
    console.log(dados)

    fetch("http://localhost:8080/auth/registroConsultas", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(dados)
    })
        .then(function (res) {
            if (!res.ok) {
                throw new Error(`Erro na requisição: ${res.status}`);
            }
            return res.json();
        })
        .then(function (data) {
            console.log(data);
            const id_consulta = data.idConsulta
            alert("Consulta Marcada")
            window.location.href = `consData.html?id=${id_consulta}`;
        })
        .catch(function (error) {
            console.error(error);
        });
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    salvar();
})