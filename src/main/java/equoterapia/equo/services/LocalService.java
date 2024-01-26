package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Local;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.LocalRepository;

@Service
public class LocalService {
	@Autowired
	LocalRepository repo;
	
	public Local salvar(Local local) {
		validaCampos(local);	
		
		return repo.save(local);
	}
	
	public Local consultar(Long id) {
		Optional<Local> opt = repo.findById(id);
		Local lc = opt.orElseThrow(() -> new RecursoNaoEncontrado("Local não encontrado."));
		return lc;						
	}
	
	public Local alterar(Long idLocal, Local local) {
		Local lc = consultar(idLocal);
		validaCampos(local);
		lc.setUf(local.getUf());
		lc.setCep(local.getCep());
		lc.setCidade(local.getCidade());
		lc.setRua(local.getRua());
		lc.setNumero(local.getNumero());
		lc.setCnpj(local.getCnpj());
		return repo.save(lc);
	}
	public void excluir(Long id) {
		Local lc = consultar(id);
		repo.delete(lc);
	}
	private void validaCampos(Local local) {
		if(local.getUf().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(local.getCep()<= 0) {
			throw new ValidaDadosException("O CEP deve ser informado");
		}
		if(local.getCidade().equals("")) {
			throw new ValidaDadosException("A CIDADE deve ser informado");
		}
		if(local.getRua().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(local.getCnpj().equals("")) {
			throw new ValidaDadosException("O CNPJ deve ser informado");
		}
		if(local.getNumero() <= 0) {
		    throw new ValidaDadosException("O Numero deve ser informada e ser maior que zero");
		}
	}
}
