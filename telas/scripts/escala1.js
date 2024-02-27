function saveData(page) {
    
    const op1Value = document.getElementById('op1_' + page).value;
    const op2Value = document.getElementById('op2_' + page).value;
    const op3Value = document.getElementById('op3_' + page).value;
    const op4Value = document.getElementById('op4_' + page).value;
    
    localStorage.setItem(`${page}_op1`, op1Value);
    localStorage.setItem(`${page}_op2`, op2Value);
    
    fetch('http://localhost:8080/auth/registraEscala1', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            page,
            op1: op1Value,
            op2: op2Value,
            op3: op3Value,
            op4: op4Value,
            
        }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Dados salvos com sucesso:', data);
        
        document.getElementById('escalaForm').reset();
    })
    .catch(error => console.error('Erro ao salvar dados:', error));
}

function irParaProximaPagina(page) {
    if (page < 3) {
        window.location.href = 'escala' + (page + 1) + '.html';
    } else {
        alert('Você está na última página.');
       
    }
}
