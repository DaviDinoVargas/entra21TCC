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
import equoterapia.equo.repositories.PacienteRepository;
import equoterapia.equo.services.PacienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class PacienteController {
	List<Paciente> paciente = new ArrayList<>();

	@Autowired
	PacienteRepository repository;

	@Autowired
	PacienteService service;

	@GetMapping("/pacientes")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/pacientes/{id}")
	public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {

		Optional<Paciente> opt = repository.findById(id);
		try {
			Paciente comp = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(comp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compromisso não encontrado");
		}
	}

	@GetMapping("/pacientes/cpf/{cpf}")
	public ResponseEntity<?> consultarC(@PathVariable("cpf") String cpf) {
	    Optional<Paciente> opt = repository.findByCpf(cpf);
	    try {
			Paciente comp = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(comp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não encontrado");
		}
	}

	@PostMapping("/registroPaciente")
	public ResponseEntity<?> registro(@RequestBody Paciente paciente) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(paciente));
	}

	@PutMapping("/pacientes/{idPaciente}")
	public ResponseEntity<Object> alterar(@PathVariable("idPaciente") Long idPaciente, @RequestBody Paciente paciente) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idPaciente, paciente));
	}

	@DeleteMapping("/pacientes/{id}")
	public ResponseEntity<?> deletePaciente(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
