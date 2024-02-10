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

import equoterapia.equo.entidades.Medico;
import equoterapia.equo.repositories.MedicoRepository;
import equoterapia.equo.services.MedicoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class MedicoController {
	List<Medico> medicos = new ArrayList<>();
	
	@Autowired
	MedicoRepository repository;

	@Autowired
	MedicoService service;
	
	@GetMapping("/medicos")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/registromedico")
	public ResponseEntity<?> registro(@RequestBody Medico medico) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(medico));
	}

	@PutMapping("/medicos/{idMedico}")
	public ResponseEntity<Object> alterar(@PathVariable("idMedico") Long idMedico, @RequestBody Medico medico) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idMedico, medico));
	}

	@DeleteMapping("/medico/{id}")
	public ResponseEntity<Object> deletemedico(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}