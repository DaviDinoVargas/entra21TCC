package equoterapia.equo.controllers;

import java.util.ArrayList;
import java.util.List;

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

import equoterapia.equo.entidades.Instrutor;
import equoterapia.equo.repositories.InstrutorRepository;
import equoterapia.equo.services.InstrutorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class InstrutorController {
	List<Instrutor> instrutores = new ArrayList<>();
	
	@Autowired
	InstrutorRepository repository;
	
	@Autowired
	InstrutorService service;
	
	@GetMapping("/instrutor")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/registroinstrutor")
	public ResponseEntity<Object> registro(@RequestBody Instrutor instrutor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(instrutor));
	}

	@PutMapping("/instrutor/{idInstrutor}")
	public ResponseEntity<Object> alterar(@PathVariable("idInstrutor") Long idInstrutor, @RequestBody Instrutor instrutor) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idInstrutor, instrutor));
	}

	@DeleteMapping("/instrutor/{id}")
	public ResponseEntity<Object> deletemedico(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}