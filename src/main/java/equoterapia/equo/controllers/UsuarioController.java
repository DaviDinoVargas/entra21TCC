package equoterapia.equo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equoterapia.equo.config.TokenService;
import equoterapia.equo.entidades.Usuario;
import equoterapia.equo.repositories.UserRepository;
@CrossOrigin("*")
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
	UserRepository repository;
	
	@PostMapping("/login")
	public ResponseEntity<?> logar(@RequestBody Usuario user){
		var userALogar = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		var authenticador = this.authenticationManager.authenticate(userALogar);
		var token = tokenService.generateToken((Usuario)authenticador.getPrincipal());
		return ResponseEntity.ok().body(token);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Usuario user){
		if(this.repository.findByEmail(user.getEmail()) != null) {
		  return ResponseEntity.badRequest().build();
		}
		
		/*if(user.getRole().equals("ADMIN")){
			return ResponseEntity.badRequest().build();
		}*/
		
		String passwordEndoded = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(passwordEndoded);
		Usuario novoUsuario = repository.save(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}
}