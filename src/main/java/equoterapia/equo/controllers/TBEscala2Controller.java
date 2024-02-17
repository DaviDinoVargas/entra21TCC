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

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.entidades.TBEscala2;
import equoterapia.equo.repositories.TBEscala2Repository;
import equoterapia.equo.services.TBEscala2Service;
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class TBEscala2Controller {
	List<TBEscala2> escala = new ArrayList<>();
	
	@Autowired
	TBEscala2Repository repository;

	@Autowired
	TBEscala2Service service;
	
	@GetMapping("/escala2")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping("/registraEscala2")
	public ResponseEntity<Object> registro(@RequestBody TBEscala2 escala) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(escala));
	}
	@PutMapping("/escala2/{idEscala}")
	public ResponseEntity<Object> alterar(@PathVariable("idEscala") Long idEscala, @RequestBody TBEscala2 escala) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idEscala, escala));
	}
	@DeleteMapping("/escala2/{id}")
	public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/escala2/cpfPaciente/{cpfPaciente}")
	public ResponseEntity<Object> consultar(@PathVariable("cpfPaciente") String cpfPaciente) {
	    List<TBEscala2> resultados = repository.findByCpfPaciente(cpfPaciente);

	    if (!resultados.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.OK).body(resultados);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum resultado encontrado para o CPF fornecido");
	    }
	}
}