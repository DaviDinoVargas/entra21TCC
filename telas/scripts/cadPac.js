const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Ires = document.querySelector(".nome_responsavel")
const Isexo = document.querySelector(".sexo");
const Iidata = document.querySelector(".idata");
const Icpf = document.querySelector(".cpf");
const Iemail = document.querySelector(".email");
const Icep = document.querySelector(".cep");
const Irua = document.querySelector(".rua");
const Ibairro = document.querySelector(".bairro");
const Icidade = document.querySelector(".cidade");
const Iuf = document.querySelector(".uf");
const Icomplemento = document.querySelector(".complemento");
const Inumero = document.querySelector(".numero");
const pais ="brasil";

function cadastrar(){
    const dados = {
        nome_paciente: Inome.value,
        nome_responsavel: Ires.value,
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
            complemento: Icomplemento.value,
            numero: Inumero.value,
            pais: pais
        }
    }
    fetch("http://localhost:8080/auth/registroPaciente", {
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

    cadastrar();
})
function limpar(){
    Isexo.value = "";
    Ires.value = "";
    Iidata.value = "";
    Icpf.value = "";
    Iemail.value = "";
    Icep.value = "";
    Irua.value = "";
    Ibairro.value = "";
    Icidade.value = "";
    Iuf.value = "";
    Icomplemento.value = "";
    Inumero.value = "";
    Inome.value = "";
}
