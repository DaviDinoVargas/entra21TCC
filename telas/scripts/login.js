const email = document.getElementById("email")
const password = document.getElementById("password")
const botaologar = document.getElementById("logarbutton")
botaologar.addEventListener('click', (e)=>{
    e.preventDefault()
    realizarLogin(email.value, password.value)
})

async function realizarLogin(email, senha) {
    let user = {
        email:email,
        password:senha
    }
    console.log(user);
    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        });
        console.log(response);

            const data = await response.text();
        console.log(data)
        
    } catch (error) {
        console.error('Erro no login:', error.message);
        console.log('Erro no login. Verifique suas credenciais.');
    }
} 


function decodificaTokenJwt(token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    
    window.location.replace("indexL.html");
    return JSON.parse(jsonPayload);
}

function verificaSeLogado(){
    let token =  sessionStorage.getItem('token')
    if(token != null){
        let userLogado = decodificaTokenJwt(token)
        document.getElementById("userLogado").innerHTML = Olá, $;{userLogado.sub}
        document.getElementById("userLogado").style='display:block'
        document.getElementById("logout").style='display:block'
    }
  else{
    document.getElementById("userLogado").style='display:none'
    document.getElementById("logout").style='display:none'
  }
}

function logout(){
    sessionStorage.removeItem('token')
    verificaSeLogado()
}