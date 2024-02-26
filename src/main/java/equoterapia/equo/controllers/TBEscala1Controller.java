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

import equoterapia.equo.entidades.Paciente;
import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.repositories.TBEscala1Repository;
import equoterapia.equo.services.TBEscala1Service;
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class TBEscala1Controller {
	List<TBEscala1> escala = new ArrayList<>();
	
	@Autowired
	TBEscala1Repository repository;

	@Autowired
	TBEscala1Service service;
	
	@GetMapping("/escala1")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping("/registraEscala1")
	public ResponseEntity<Object> registro(@RequestBody TBEscala1 escala) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(escala));
	}
	@PutMapping("/escala1/{idEscala}")
	public ResponseEntity<Object> alterar(@PathVariable("idEscala") Long idEscala, @RequestBody TBEscala1 escala) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idEscala, escala));
	}
	@DeleteMapping("/escala1/{id}")
	public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/escala1/cpfPaciente/{cpfPaciente}")
	public ResponseEntity<Object> consultar(@PathVariable("cpfPaciente") String cpfPaciente) {
	    List<TBEscala1> resultados = repository.findByCpfPaciente(cpfPaciente);

	    if (!resultados.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.OK).body(resultados);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum resultado encontrado para o CPF fornecido");
	    }
	}
	
}