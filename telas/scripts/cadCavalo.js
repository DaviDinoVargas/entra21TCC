const formulario = document.querySelector("form");
const Inome = document.getElementById("nomeCavalo");
const Iidade = document.getElementById("idade");
const Iraca = document.getElementById("raca");

function cadastrar(){
    const dados = {
        raca: Iraca.value,
        idade: parseInt(Iidade.value),
        nome: Inome.value
    }
fetch("http://localhost:8080/auth/registroCavalo", {
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify(dados)
})
.then(function (res) { console.log(res); alert("Cavalo Cadastrado com Sucesso!")})
.catch(function (res) { console.log(res.data) })
console.log(dados)

Iraca.value= ""
Iidade.value = ""
Inome.value = ""
};

formulario.addEventListener('submit', function (event){
event.preventDefault();

cadastrar();
})