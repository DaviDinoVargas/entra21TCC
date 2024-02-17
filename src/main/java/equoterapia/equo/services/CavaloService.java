package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Cavalo;
import equoterapia.equo.exceptions.RecursoJaExistente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.CavaloRepository;

@Service
public class CavaloService {
	@Autowired
	CavaloRepository repo;
	
	public Cavalo salvar(Cavalo cavalo) {
		//validaCampos(cavalo);	
		/*if (repo.findById((long) cavalo.getId()) != null) {
			throw new RecursoJaExistente("Cavalo já cadastrado para esse email");
		}	*/
		return repo.save(cavalo);
	}
	
	public Cavalo consultar(Long id) {
		Optional<Cavalo> opt = repo.findById(id);
		Cavalo cv = opt.orElseThrow(() -> new RecursoNaoEncontrado("Cavalo não encontrado."));
		return cv;						
	}
	
	public Cavalo alterar(Long idCavalo, Cavalo cavalo) {
		Cavalo cv = consultar(idCavalo);
		//validaCampos(cavalo);
		cv.setNome(cavalo.getNome());
		cv.setIdade(cavalo.getIdade());
		cv.setRaca(cavalo.getRaca());
		return repo.save(cv);
	}
	public void excluir(Long id) {
		Cavalo cv = consultar(id);
		repo.delete(cv);
	}
	private void validaCampos(Cavalo cavalo) {
		if(cavalo.getNome().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		if(cavalo.getRaca().equals("")) {
			throw new ValidaDadosException("O email deve ser informado");
		}
		
		if(cavalo.getIdade() <= 0) {
		    throw new ValidaDadosException("A idade deve ser informada e maior que zero");
		}
	}
}
