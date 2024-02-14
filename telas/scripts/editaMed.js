const params = new URLSearchParams(window.location.search);
const id = params.get('id');

document.addEventListener("DOMContentLoaded", ()=> {
    preencherDados();
})
async function preencherDados(){
    try {
        let url = await fetch(`http://localhost:8080/auth/medicos/${id}`);
        let response = await url.json();

        document.getElementById('nome').value = response.nome_medico;
        document.getElementById('cpf').value = response.cpf;
        document.getElementById('email').value = response.email_medico;
        document.getElementById('sexo').value = response.sexo;
        document.getElementById('idata').value = response.data_nascimento_med;

        // Corrigir aqui: usar response.endereco_paciente_id ao invés de response.endereco_paciente
        document.getElementById('cep').value = response.endereco_Medico_id.cep;
        document.getElementById('rua').value = response.endereco_Medico_id.rua;
        document.getElementById('bairro').value = response.endereco_Medico_id.bairro;
        document.getElementById('complemento').value = response.endereco_Medico_id.complemento;
        document.getElementById('cidade').value = response.endereco_Medico_id.cidade;
        document.getElementById('uf').value = response.endereco_Medico_id.uf;
        document.getElementById('numero').value = response.endereco_Medico_id.numero;
    } catch (error) {
        console.error("Erro ao preencher dados:", error);
    }
}
const formulario = document.querySelector("form");
function atualizar(){
    const Inome = document.querySelector("#nome");
    const Isexo = document.querySelector("#sexo");
    const Iidata = document.querySelector("#idata");
    const Icpf = document.querySelector("#cpf");
    const Iemail = document.querySelector("#email");
    const Icep = document.querySelector("#cep");
    const Irua = document.querySelector("#rua");
    const Ibairro = document.querySelector("#bairro");
    const Icidade = document.querySelector("#cidade");
    const Iuf = document.querySelector("#uf");
    const Inumero = document.querySelector("#numero");
    const Icomp = document.querySelector("#complemento")
    const pais ="brasil";
    console.log("entrei aqui")

    const dados = {
        nome_medico: Inome.value,
        sexo: Isexo.value,
        data_nascimento_med: Iidata.value,
        cpf: Icpf.value,
        email_medico: Iemail.value,
        endereco_medico_id:{
            cep: Icep.value,
            rua: Irua.value,
            bairro: Ibairro.value,
            cidade: Icidade.value,
            uf: Iuf.value,
            numero: Inumero.value,
            complemento: Icomp.value,
            pais: pais
        }
    }
    fetch(`http://localhost:8080/auth/medicos/${id}`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "PUT",
        body: JSON.stringify(dados)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res.data) })
    console.log(dados)
    alert("Paciente atualizado com Sucesso!")

};

formulario.addEventListener('submit', function (event){
    event.preventDefault();

    atualizar();
})