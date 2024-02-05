const formulario = document.querySelector("form");
const Iinst = document.querySelector(".instituicao");
const Icnpj = document.querySelector(".cnpj");
const Icep = document.querySelector(".cep");
const Iendereco = document.querySelector(".endereco");
const Ibairro = document.querySelector(".bairro");
const Icidade = document.querySelector(".cidade");
const Iuf = document.querySelector(".uf");
const Iemail = document.querySelector(".email");
const Iddd = document.querySelector(".ddd");
const Icelular = document.querySelector(".celular");
const Icomentario = document.querySelector(".comentario");

function cadastrar(){
    fetch("http://localhost:8080/auth/registroUsuario", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(dados)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
    console.log(dados)

};

const dados = {
    instituicao: Iinst.value,
    cnpj: Icnpj.value,
    cep: Icep.value,
    endereco: Iendereco.value,
    bairro: Ibairro.value,
    cidade: Icidade.value,
    uf: Iuf.value,
    email: Iemail.value,
    ddd: Iddd.value,
    celular: Icelular.value,
    comentario: Icomentario.value
}

formulario.addEventListener('submit', function (event){
    event.preventDefault();

    cadastrar();
})