	
		function getAlunos(alunoId) {
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				const alunos = JSON.parse(this.response);
				initMap(alunos)
			}
			xhttp.open("POST", "../api/alunos", true);

			xhttp.send(alunoId);
		}

		function initMap(alunos) {

			// The location
			const escola = {
				lat : -15.8196436,
				lng : -47.8965739
			};

			// The map, centered the location
			const map = new google.maps.Map(document.getElementById("map"), {
				zoom : 14,
				center : alunos[0],
			});
			// The marker
			const marker = new google.maps.Marker({
				position : escola,
				map : map,
				label : 'Escola',
			});
			
			for (aluno of alunos) {
				new google.maps.Marker({
					position : aluno,
					map : map,
					label : aluno.nome,
				});
			}
			

		}

		window.initMap = initMap;