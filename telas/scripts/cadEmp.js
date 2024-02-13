const formulario = document.querySelector("form");
const Iemail = document.querySelector("#email")
const Isenha = document.querySelector("#password")
function cadastrar(){
    const dados = {
        email: Iemail.value,
        password: Isenha.value
    }
fetch("http://localhost:8080/auth/register", {
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
alert("Dados enviados com sucesso!")

};


formulario.addEventListener('submit', function (event){
event.preventDefault();

cadastrar();
})