package equoterapia.equo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equoterapia.equo.entidades.TBEscala2;
import equoterapia.equo.entidades.TBEscala3;
import equoterapia.equo.repositories.TBEscala3Repository;
import equoterapia.equo.services.TBEscala3Service;
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class TBEscala3Controller {
	List<TBEscala3> escala = new ArrayList<>();
	
	@Autowired
	TBEscala3Repository repository;

	@Autowired
	TBEscala3Service service;
	
	@GetMapping("/escala3")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping("/registraEscala3")
	public ResponseEntity<Object> registro(@RequestBody TBEscala3 escala) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(escala));
	}
	@PutMapping("/escala3/{idEscala}")
	public ResponseEntity<Object> alterar(@PathVariable("idEscala") Long idEscala, @RequestBody TBEscala3 escala) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idEscala, escala));
	}
	@DeleteMapping("/escala3/{id}")
	public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/escala3/cpfPaciente/{cpfPaciente}")
	public ResponseEntity<Object> consultar(@PathVariable("cpfPaciente") String cpfPaciente) {
	    List<TBEscala3> resultados = repository.findByCpfPaciente(cpfPaciente);

	    if (!resultados.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.OK).body(resultados);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum resultado encontrado para o CPF fornecido");
	    }
	}
}