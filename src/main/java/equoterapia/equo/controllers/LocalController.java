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

import equoterapia.equo.entidades.Local;
import equoterapia.equo.repositories.LocalRepository;
import equoterapia.equo.services.LocalService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class LocalController {
	List<Local> locais = new ArrayList<>();

	@Autowired
	LocalRepository repository;

	@Autowired
	LocalService service;

	@GetMapping("/locais")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/registroLocais")
	public ResponseEntity<Object> registro(@RequestBody Local local) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(local));
	}

	@PutMapping("/locais/{idLocal}")
	public ResponseEntity<Object> alterar(@PathVariable("idLocal") Long idLocal, @RequestBody Local local) {

		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idLocal, local));
	}

	@DeleteMapping("/locais/{id}")
	public ResponseEntity<Object> deleteLocal(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}