const header = `<button id"=menu-button"><img><Main>MENU</Main></button>

<nav class="sidebar">
    <ul>
        <li class="item-menu">
            <a href="indexL.html">             
    <span class="icon"><i class="bi bi-house"></i></span>
    <span class="txt-link">Home</span>                
</a>
</li>
<li class="item-menu">
<a href="consulta.html">
    <span class="icon"><i class="bi bi-person-circle"></i></span>
    <span class="txt-link">Pacientes</span>
</a>
</li>
<li class="item-menu">
<a href="consultaInstrutor.html">
    <span class="icon"><i class="bi bi-person-badge-fill"></i></span>
    <span class="txt-link">Instrutores</span>
</a>
<li class="item-menu">
<a href="consultaMed.html">
    <span class="icon"><i class="bi bi-bandaid"></i></span>
    <span class="txt-link">M&eacute;dicos</span>
</a>
</li>
<li class="item-menu">
<a href="agenda.html">
    <span class="icon"><i class="bi bi-calendar"></i></span>
    <span class="txt-link">Agenda</span>
</a>
</li>
<li class="item-menu">
<a href="#">
<span class="icon"><i class="bi bi-backpack4-fill"></i></span>
    <span class="txt-link">Cavalos</span>
</a>
</li>
<li class="item-menu">
<a href="index.html">             
    <span class="icon"><i class="bi bi-x-circle-fill"></i></span>
    <span class="txt-link">Sair</span>
</a>
</li></ul>
</nav>
`


document.addEventListener("DomContentLoaded", function () {
    const menuButton = document.getElementbyId("menu-button");
    const sidebar = document.querySelector(".sidebar");

    menuButton.addEventListener("click", function () {
        sidebar.classList.toggle("show-sidebar");

    });
});
const dataHeader = document.createElement("nav");
document.body.appendChild(dataHeader);
dataHeader.innerHTML = header;
