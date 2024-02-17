const params = new URLSearchParams(window.location.search);
const id = params.get('id');

document.addEventListener("DOMContentLoaded", ()=> {
    preencherDados();
})

async function preencherDados(){
    try {
        let url = await fetch(`http://localhost:8080/auth/consulta/${id}`);
        let response = await url.json();

        document.getElementById('data').value = response.dataAvaliacao;
        document.getElementById('hora').value = response.hora;
        document.getElementById('encilhamento').value = response.encilhamento;
        
        document.getElementById('cidade').value = response.local.cidade;
        document.getElementById('nome').value = response.paciente.nome_paciente;

    } catch (error) {
        console.error("Erro ao preencher dados:", error);
    }
}