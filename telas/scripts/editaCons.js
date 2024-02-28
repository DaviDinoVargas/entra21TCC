const params = new URLSearchParams(window.location.search);
const id = params.get('id');

document.addEventListener("DOMContentLoaded", () => {
    preencherDados();
})
async function preencherDados() {
    try {
        let url = await fetch(`http://localhost:8080/auth/consulta/${id}`);
        let response = await url.json();

        console.log(response)

        document.getElementById('nome').value = response.paciente.nome_paciente;
        document.getElementById('cpf').value = response.paciente.cpf;

        document.getElementById('cavalo').value = response.cavalo.nome;

        document.getElementById('hora').value = response.hora;
        document.getElementById('idata').value = response.dataAvaliacao;
        document.getElementById('encilhamento').value = response.encilhamento;
        document.getElementById('condicao_saude').value = response.condicaoSaude;

        document.getElementById('medico').value = response.medico.nome;

        document.getElementById('cep').value = response.local.cep;
        document.getElementById('rua').value = response.local.rua;
        document.getElementById('bairro').value = response.local.bairro;
        document.getElementById('complemento').value = response.local.complemento;
        document.getElementById('cidade').value = response.local.cidade;
        document.getElementById('uf').value = response.local.uf;
        document.getElementById('numero').value = response.local.numero;
    } catch (error) {
        console.error("Erro ao preencher dados:", error);
    }
}
const formulario = document.querySelector("form");
function atualizar() {
    const Iid = document.querySelector("#id");
    const cavalo = document.querySelector("#idCav");
    const Ihora = document.querySelector("#hora")
    const Idata = document.querySelector("#idata")
    const Iencilhamento = document.querySelector(".encilhamento")
    const Isaude = document.querySelector(".condicao_saude")
    const Imedico = document.querySelector("#idMed")
    const Iinstrutor = document.querySelector("#instrutor_1")
    const Icep = document.querySelector(".cep");
    const Irua = document.querySelector(".rua");
    const Icidade = document.querySelector(".cidadeC");
    const Ibairro = document.querySelector(".bairro")
    const Icomplemento = document.querySelector(".complemento")
    const Iuf = document.querySelector(".uf");
    const Inumero = document.querySelector(".numero");

    const dados = {
        hora: Ihora.value,
        dataAvaliacao: Idata.value,
        encilhamento: Iencilhamento.value,
        condicaoSaude: Isaude.value,
        local: {
            cep: Icep.value,
            rua: Irua.value,
            cidade: Icidade.value,
            bairro: Ibairro.value,
            complemento: Icomplemento.value,
            uf: Iuf.value,
            numero: Inumero.value
        },
        paciente: {
            id_paciente: Iid.value
        },
        medico: {
            id_medico: Imedico.value
        },
        cavalo: {
            id_cavalo: cavalo.value
        }

    }
    console.log(dados)

    fetch(`http://localhost:8080/auth/consultas/${id}`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "PUT",
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
            alert("Consulta Atualizada")
            window.location.href = "agenda.html";
        })
        .catch(function (error) {
            console.error(error);
        });
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    atualizar();
})
