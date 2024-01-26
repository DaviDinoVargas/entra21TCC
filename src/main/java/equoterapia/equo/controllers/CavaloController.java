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

import equoterapia.equo.entidades.Cavalo;
import equoterapia.equo.repositories.CavaloRepository;
import equoterapia.equo.services.CavaloService;

@RestController
@RequestMapping("/cavalo")
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

	@PostMapping("/registro")
	public ResponseEntity<Object> registro(@RequestBody Cavalo cavalo) {

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
