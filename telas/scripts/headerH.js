const header = `
<header>
    <ul class="ul1">
        <a href="cadastro.html">
            <li>Cadastro</li>
        </a>
        <a href="index.html">
            <li>Sobre n&oacute;s</li>
        </a>
        <a href="sobre.html">
            <li>Sobre o Projeto</li>
        </a>
        <a href="login.html">
            <li>O Que &eacute; Ecoterapia?</li>
        </a>
        <a href="#">
            <li>Base de Pesquisas</li>
        </a>
        <a href="login.html" class="logg">
            <li>Login</li>
        </a>
    </ul>
</header>
`
const dataHeader = document.createElement("header");
document.body.appendChild(dataHeader);
dataHeader.innerHTML = header;