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

import equoterapia.equo.entidades.EscalaAvaliacao;
import equoterapia.equo.repositories.EscalaAvaliacaoRepository;
import equoterapia.equo.services.EscalaAvaliacaoService;

@RestController
@RequestMapping("/auth")
public class EscalaAvaliacaoController {
	List<EscalaAvaliacao> escalasAvaliacoes = new ArrayList<>();

	@Autowired
	EscalaAvaliacaoRepository repository;

	@Autowired
	EscalaAvaliacaoService service;

	@GetMapping("/avaliacoes")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/registroAvaliacao")
	public ResponseEntity<Object> registro(@RequestBody EscalaAvaliacao avaliacao) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(avaliacao));
	}

	@PutMapping("/avaliacoes/{id}")
	public ResponseEntity<Object> alterar(@PathVariable("idAvaliacao") Long idAvaliacao,
			@RequestBody EscalaAvaliacao avaliacao) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idAvaliacao, avaliacao));

	}
	@DeleteMapping("/avaliacoes/{id}")
	public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}