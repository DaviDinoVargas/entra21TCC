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

import equoterapia.equo.entidades.Endereco;
import equoterapia.equo.entidades.Paciente;
import equoterapia.equo.repositories.EnderecoRepository;
import equoterapia.equo.services.EnderecoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class EnderecoController {
	List<Endereco> enderecos = new ArrayList<>();

	@Autowired
	EnderecoRepository repository;

	@Autowired
	EnderecoService service;

	@GetMapping("/enderecos")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/endereco/{id}")
	public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {

		Optional<Endereco> opt = repository.findById(id);
		try {
			Endereco comp = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(comp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compromisso não encontrado");
		}
	}
	@PostMapping("/registroEnderecos")
	public ResponseEntity<Object> registro(@RequestBody Endereco endereco) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(endereco));
	}

	@PutMapping("/enderecos/{idEndereco}")
	public ResponseEntity<Object> alterar(@PathVariable("idEndereco") Long idEndereco, @RequestBody Endereco endereco) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idEndereco, endereco));
	}

	@DeleteMapping("/enderecos/{id}")
	public ResponseEntity<Object> deleteEndereco(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
