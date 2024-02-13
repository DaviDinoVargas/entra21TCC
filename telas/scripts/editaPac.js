const params = new URLSearchParams(window.location.search);
const id = params.get('id');

document.addEventListener("DOMContentLoaded", ()=> {
    preencherDados();
})
async function preencherDados(){
    let url = await fetch(`http://localhost:8080/auth/pacientes/${id}`)
   

    let response = await url.json()
                
    document.getElementById('nome').value = response.nome_paciente
    document.getElementById('cpf').value = response.cpf
    document.getElementById('email').value = response.email_paciente
    document.getElementById('sexo').value = response.sexo
    document.getElementById('data_nascimento').value = response.data_nascimento

    document.getElementById('cep').value = response.cep
    document.getElementById('rua').value = response.rua
    document.getElementById('bairro').value = response.bairro
    document.getElementById('cidade').value = response.cidade
    document.getElementById('uf').value = response.uf
    document.getElementById('numero').value = response.numero


}

const formulario = document.querySelector("form");
function atualizar(){
    const Inome = document.querySelector("#nome");
    const Isexo = document.querySelector("#sexo");
    const Iidata = document.querySelector("#data_nascimento");
    const Icpf = document.querySelector("#cpf");
    const Iemail = document.querySelector("#email");
    const Icep = document.querySelector("#cep");
    const Irua = document.querySelector("#rua");
    const Ibairro = document.querySelector("#bairro");
    const Icidade = document.querySelector("#cidade");
    const Iuf = document.querySelector("#uf");
    const Inumero = document.querySelector("#numero");
    const pais ="brasil";
    console.log("entrei aqui")

    const dados = {
        nome_paciente: Inome.value,
        sexo: Isexo.value,
        data_nascimento: Iidata.value,
        cpf: Icpf.value,
        email_paciente: Iemail.value,
        endereco_paciente_id:{
            cep: Icep.value,
            rua: Irua.value,
            bairro: Ibairro.value,
            cidade: Icidade.value,
            uf: Iuf.value,
            numero: Inumero.value,
            pais: pais
        }
    }
    fetch(`http://localhost:8080/auth/pacientes/${id}`, {
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