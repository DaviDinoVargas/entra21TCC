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

import equoterapia.equo.entidades.Cavalo;
import equoterapia.equo.entidades.Medico;
import equoterapia.equo.repositories.CavaloRepository;
import equoterapia.equo.services.CavaloService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class CavaloController {
	List<Cavalo> cavalos = new ArrayList<>();

	@Autowired
	CavaloRepository repository;

	@Autowired
	CavaloService service;

	@GetMapping("/cavalos")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/cavalos/nome/{nome}")
	public ResponseEntity<?> consultarC(@PathVariable("nome") String nome) {
	    Optional<Cavalo> opt = repository.findByNome(nome);
	    try {
	    	Cavalo comp = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(comp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não encontrado");
		}
	}

	@PostMapping("/registroCavalo")
	public ResponseEntity<?> registro(@RequestBody Cavalo cavalo) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cavalo));
	}

	@PutMapping("/cavalos/{idCavalo}")
	public ResponseEntity<Object> alterar(@PathVariable("idCavalo") Long idCavalo, @RequestBody Cavalo cavalo) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idCavalo, cavalo));
	}

	@DeleteMapping("/cavalos/{id}")
	public ResponseEntity<Object> deleteCavalo(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
