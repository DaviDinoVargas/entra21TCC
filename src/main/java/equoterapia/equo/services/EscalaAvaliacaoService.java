package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.EscalaAvaliacao;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.EscalaAvaliacaoRepository;

@Service
public class EscalaAvaliacaoService {
	@Autowired
	EscalaAvaliacaoRepository repo;
	
	public EscalaAvaliacao salvar(EscalaAvaliacao escalaAvaliacao) {
		validaCampos(escalaAvaliacao);	
		
		return repo.save(escalaAvaliacao);
	}
	
	public EscalaAvaliacao consultar(Long id) {
		Optional<EscalaAvaliacao> opt = repo.findById(id);
		EscalaAvaliacao cons = opt.orElseThrow(() -> new RecursoNaoEncontrado("EscalaAvaliacao não encontrada."));
		return cons;						
	}
	
	public EscalaAvaliacao alterar(Long idEscalaAvaliacao, EscalaAvaliacao escalaAvaliacao) {
		EscalaAvaliacao escAv = consultar(idEscalaAvaliacao);
		validaCampos(escalaAvaliacao);
		escAv.setSomaTotal(escalaAvaliacao.getSomaTotal());
		
		return repo.save(escAv);
	}
	public void excluir(Long id) {
		EscalaAvaliacao end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(EscalaAvaliacao escalaAvaliacao) {
		if(escalaAvaliacao.getSomaTotal() <= 0) {
			throw new ValidaDadosException("A SOMA TOTAL deve ser informado");
		}
	}
}