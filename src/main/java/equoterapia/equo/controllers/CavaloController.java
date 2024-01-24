package equoterapia.equo.controllers;

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


import equoterapia.entidades.Cavalo;
import equoterapia.equo.repositories.CavaloRepository;

@RestController
@RequestMapping("/auth")
public class CavaloController {

	@Autowired
	CavaloRepository repository;

	@GetMapping("/cavalos")
	public ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/registro")
	public ResponseEntity<?> registro(@RequestBody Cavalo cavalo) {

		if (this.repository.findByName(cavalo.getNome()) != null) {
			return ResponseEntity.badRequest().build();
		}
		Cavalo novoCavalo = repository.save(cavalo);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCavalo);
	}
	@PutMapping("/cavalos/{id}")
	public ResponseEntity<?> alterar(@PathVariable("id") Long id, @RequestBody Cavalo cavalo){
		Cavalo oldHorse = repository.findById(id).get();
		oldHorse.setNome(cavalo.getNome());
		oldHorse.setIdade(cavalo.getIdade());
		oldHorse.setRaca(cavalo.getRaca());
		
		Cavalo horseAlterado = repository.save(oldHorse);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(horseAlterado);
	}
	@DeleteMapping("/cavalos/{id}")
	public ResponseEntity<?> deleteCavalo(@PathVariable("id") Long id){
		Cavalo oldHorse = repository.findById(id).get();
		repository.delete(oldHorse);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
