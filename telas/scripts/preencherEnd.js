async function preencherEndereco(){
         
    const Icep = document.querySelector(".cep");
    const Ncep = Icep.value
    let url = await fetch(`https://viacep.com.br/ws/${Ncep}/json/`)               
        
    let response = await url.json()
        
    document.querySelector('.rua').value = response.logradouro
    document.querySelector('.complemento').value = response.complemento
    document.querySelector('.cidade').value = response.cidade
    document.querySelector('.bairro').value = response.bairro
    document.querySelector('.uf').value = response.uf
}