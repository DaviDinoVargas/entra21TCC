async function preencherDados(){
    let Nid = id.value
    let url = await fetch(`http://localhost:8080/auth/pacientes/${Nid}`)

    let urlEnd = await fetch(`http://localhost:8080/auth/endereco/${Nid}`)


    let response = await url.json()
                
    document.getElementById('nome').value = response.nome_paciente
    document.getElementById('cpf').value = response.cpf
    document.getElementById('email').value = response.email_paciente
    
    let responseEnd = await urlEnd.json() 
    document.getElementById('cep').value = responseEnd.cep
    document.getElementById('rua').value = responseEnd.rua
    document.getElementById('bairro').value = responseEnd.bairro
    document.getElementById('cidade').value = responseEnd.cidade
    document.getElementById('uf').value = responseEnd.uf
    document.getElementById('numero').value = responseEnd.numero


}

const formulario = document.querySelector("form");
function atualizar(){
    const Inome = document.querySelector(".nome");
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
    console.log("entrei aqui")
    let Nid = id.value

    const dados = {
        nome_paciente: Inome.value,
        sexo: Isexo.value,
        data: Iidata.value,
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
    fetch(`http://localhost:8080/auth/pacientes/${Nid}`, {
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