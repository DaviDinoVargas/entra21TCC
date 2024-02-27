document.addEventListener('DOMContentLoaded', function () {

    function fetchAndPlotGraph() {
        const cpfPacEscala = localStorage.getItem('cpfPacEscala');
        const urlEscala1 = `http://localhost:8080/auth/escala1/cpfPaciente/${cpfPacEscala}`;
        const urlEscala2 = `http://localhost:8080/auth/escala2/cpfPaciente/${cpfPacEscala}`;
        const urlEscala3 = `http://localhost:8080/auth/escala3/cpfPaciente/${cpfPacEscala}`;

        const fetchPromises = [
            fetch(urlEscala1),
            fetch(urlEscala2),
            fetch(urlEscala3),
        ];

        Promise.all(fetchPromises)
            .then(responses => Promise.all(responses.map(response => response.json())))
            .then(dataArray => {
                console.log('Dados brutos da escala 2:', dataArray[1]);
                
                const somaDM1Data = dataArray[0].map(entry => entry.somaDM1).slice(-9);
                const somaDM2Data = dataArray[1].map(entry => entry.somaDM2).slice(-9);
                const somaDM3Data = dataArray[2].map(entry => entry.somaDM3).slice(-9);
            
                console.log('SomaDM2 Data:', somaDM2Data);
            
                createLineGraph(somaDM1Data, somaDM2Data, somaDM3Data);
            })
            .catch(error => {
                console.error('Erro ao obter dados das escalas:', error);
            });
    }

    function createLineGraph(somaDM1Data, somaDM2Data, somaDM3Data) {

        const ctx = document.getElementById('myChart').getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: Array.from({ length: somaDM1Data.length }, (_, i) => i + 1),
                datasets: [
                    {
                        label: 'Dimensão 1',
                        data: somaDM1Data,
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1,
                        fill: false,
                    },
                    {
                        label: 'Dimensão 2',
                        data: somaDM2Data,
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1,
                        fill: false,
                    },
                    {
                        label: 'Dimensão 3',
                        data: somaDM3Data,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1,
                        fill: false,
                    },
                ],
            },
            options: {
                scales: {
                    x: {
                        type: 'linear',
                        position: 'bottom',
                    },
                    y: {
                        beginAtZero: true,
                    },
                },
            },
        });
    }

    fetchAndPlotGraph();
});
