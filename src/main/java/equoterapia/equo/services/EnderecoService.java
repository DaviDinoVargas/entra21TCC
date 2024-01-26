package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Endereco;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repo;
	
	public Endereco salvar(Endereco endereco) {
		validaCampos(endereco);	
		
		return repo.save(endereco);
	}
	
	public Endereco consultar(Long id) {
		Optional<Endereco> opt = repo.findById(id);
		Endereco cv = opt.orElseThrow(() -> new RecursoNaoEncontrado("Endereco não encontrado."));
		return cv;						
	}
	
	public Endereco alterar(Long idEndereco, Endereco endereco) {
		Endereco end = consultar(idEndereco);
		validaCampos(endereco);
		end.setUf(endereco.getUf());
		end.setCep(endereco.getCep());
		end.setCidade(endereco.getCidade());
		end.setRua(endereco.getRua());
		end.setNumero(endereco.getNumero());
		return repo.save(end);
	}
	public void excluir(Long id) {
		Endereco end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(Endereco endereco) {
		if(endereco.getUf().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(endereco.getCep()<= 0) {
			throw new ValidaDadosException("O CEP deve ser informado");
		}
		if(endereco.getCidade().equals("")) {
			throw new ValidaDadosException("A CIDADE deve ser informado");
		}
		if(endereco.getRua().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(endereco.getNumero() <= 0) {
		    throw new ValidaDadosException("A idade deve ser informada e maior que zero");
		}
	}
}
