package equoterapia.equo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equoterapia.equo.config.TokenService;
import equoterapia.equo.entidades.Usuario;
import equoterapia.equo.repositories.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
   /* private UserRepository repository;
    
    UsuarioController(UserRepository repo){
    	this.repository = repo;
    }*/
	
	@Autowired
	private AuthenticationManager authenticationManager;
    
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	UsuarioRepository repository;
	
	@GetMapping("/get")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logar(@RequestBody Usuario user){
		var userALogar = new UsernamePasswordAuthenticationToken(user.getEmpresa(), user.getSenha());
		var authenticador = this.authenticationManager.authenticate(userALogar);
		var token = tokenService.generateToken((Usuario)authenticador.getPrincipal());
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/registroUsuario")
	public ResponseEntity<?> register(@RequestBody Usuario user){
		if(this.repository.findByEmpresa(user.getEmpresa()) != null) {
		  return ResponseEntity.badRequest().build();
		}
		
		/*if(user.getRole().equals("ADMIN")){
			return ResponseEntity.badRequest().build();
		}*/
		
		String passwordEndoded = new BCryptPasswordEncoder().encode(user.getSenha());
		user.setSenha(passwordEndoded);
		Usuario novoUsuario = repository.save(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}
}
