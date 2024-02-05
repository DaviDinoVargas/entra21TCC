package equoterapia.equo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import equoterapia.equo.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByEmail(username);
	}

}