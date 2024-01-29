package equoterapia.equo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equoterapia.equo.entidades.Consulta;
import equoterapia.equo.repositories.ConsultaRepository;
import equoterapia.equo.services.ConsultaService;

@RestController
@RequestMapping("/auth")
public class ConsultaController {
	List<Consulta> consultas = new ArrayList<>();

	@Autowired
	ConsultaRepository repository;

	@Autowired
	ConsultaService service;

	@GetMapping("/consultas")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/registroConsultas")
	public ResponseEntity<Object> registro(@RequestBody Consulta consulta) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(consulta));
	}

	@PutMapping("/consultas/{idConsulta}")
	public ResponseEntity<Object> alterar(@PathVariable("idConsulta") Long idConsulta, @RequestBody Consulta consulta) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idConsulta, consulta));
	}

	@DeleteMapping("/consultas/{id}")
	public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}