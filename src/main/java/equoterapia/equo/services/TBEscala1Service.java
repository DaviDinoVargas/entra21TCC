package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.TBEscala1Repository;

@Service
public class TBEscala1Service {
	@Autowired
	TBEscala1Repository repo;
	
	public TBEscala1 salvar(TBEscala1 tBEscala) {
		validaCampos(tBEscala);	
		
		return repo.save(tBEscala);
	}
	
	public TBEscala1 consultar(Long id) {
		Optional<TBEscala1> opt = repo.findById(id);
		TBEscala1 escala = opt.orElseThrow(() -> new RecursoNaoEncontrado("TBEscala não encontrada."));
		return escala;						
	}
	
	public TBEscala1 alterar(Long idTBEscala, TBEscala1 tBEscala) {
		TBEscala1 escala = consultar(idTBEscala);
		validaCampos(tBEscala);
		escala.setOp1_11(tBEscala.getOp1_11());
		escala.setOp1_12(tBEscala.getOp1_12());
		escala.setOp1_13(tBEscala.getOp1_13());
		escala.setComentarioDM1(tBEscala.getComentarioDM1());
		escala.setSomaDM1(tBEscala.getSomaDM1());

		return repo.save(escala);
	}
	public void excluir(Long id) {
		TBEscala1 end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(TBEscala1 tBEscala) {
		if(tBEscala.getOp1_11() < 0 || tBEscala.getOp1_11() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp1_12() < 0 || tBEscala.getOp1_12() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp1_13() < 0 || tBEscala.getOp1_13() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getComentarioDM1().equals("")) {
			throw new ValidaDadosException("Você deve descrever algum comentário");
		}/* 
		if(tBEscala.getSomaDM1() <= DADOS DA SOMA(VALOR MAX E MIN) {
			throw new ValidaDadosException("O UF deve ser informado");
		}*/
	}
}
