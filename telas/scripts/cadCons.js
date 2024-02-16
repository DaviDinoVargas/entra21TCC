async function preenchePorCpf() {
    const Icpf = document.querySelector("#cpf");
    let Ncpf = Icpf.value

    let url = await fetch(`http://localhost:8080/auth/pacientes/cpf/${Ncpf}`)

    let response = await url.json()
    document.getElementById('nome').value = response.nome_paciente
    document.getElementById('id').value = response.id_paciente
}

async function buscaId() {
    const Icpf = document.querySelector("#cpf");
    let Ncpf = Icpf.value
    await fetch(`http://localhost:8080/auth/pacientes/cpf/${Ncpf}`)
        .then(data => {

            console.log(data);

            //const resultadoConsulta = document.getElementById('resultadoConsulta');

            if (data.id_paciente) {
                console.log(`ID do paciente: ${data.id_paciente}`);
                //localStorage.setItem('idPacEscala', data.id_paciente);

            }
        })
}
document.querySelector('#qtd_medicos').addEventListener('input', function (e) {
    const qtdMedicos = parseInt(e.target.value);
    const inputsMedicosDiv = document.getElementById('inputs_medicos');
    inputsMedicosDiv.innerHTML = '';
    for (let i = 0; i < qtdMedicos; i++) {
        const label = document.createElement('label');
        label.textContent = `MÃ©dico ${i + 1}:`;
        const input = document.createElement('input');
        input.type = 'text';
        input.name = `medico_${i + 1}`;
        input.id = `medico_${i + 1}`
        inputsMedicosDiv.appendChild(label);
        inputsMedicosDiv.appendChild(input);
        inputsMedicosDiv.appendChild(document.createElement('br'));
    }
});

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
const cavalo = document.querySelector("#cavalo");
const Ihora = document.querySelector("#hora")
const Idata = document.querySelector("#idata")
const Iencilhameno = document.querySelector(".encilhamento")
const Isaude = document.querySelector(".condicao_saude")
const Imedico = document.querySelector("#medico_1")
const Iinstrutor = document.querySelector("#instrutor_1")
const Icep = document.querySelector(".cep");
const Irua = document.querySelector(".rua");
const Ibairro = document.querySelector(".bairro");
const Icidade = document.querySelector(".cidade");
const Iuf = document.querySelector(".uf");
const Icomplemento = document.querySelector(".complemento");
const Inumero = document.querySelector(".numero");
const pais = "brasil"

function salvar() {
    const dados = {
        paciente_id_id_paciente: Iid.value,
        cavalo_id_id_cavalo: cavalo.value,
        hora: Ihora.value,
        data_avaliacao: Idata.value,
        encilhamento: Iencilhameno.value,
        condicao_saude: Isaude.value,
        endereco_id_id_endereco: {
            cep: Icep.value,
            rua: Irua.value,
            bairro: Ibairro.value,
            cidade: Icidade.value,
            uf: Iuf.value,
            complemento: Icomplemento.value,
            numero: Inumero.value,
            pais: pais
        }
    }
    fetch("http://localhost:8080/auth//registroConsultas", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(dados)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res.data) })
    console.log(dados)

};

formulario.addEventListener('submit', function (event){
    event.preventDefault();

    salvar();
})

