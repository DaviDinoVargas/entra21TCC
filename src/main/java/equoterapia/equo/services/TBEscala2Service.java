package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.entidades.TBEscala2;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.TBEscala2Repository;

@Service
public class TBEscala2Service {
	@Autowired
	TBEscala2Repository repo;
	
	public TBEscala2 salvar(TBEscala2 tBEscala) {
		validaCampos(tBEscala);	
		
		return repo.save(tBEscala);
	}
	
	public TBEscala2 consultar(Long id) {
		Optional<TBEscala2> opt = repo.findById(id);
		TBEscala2 escala = opt.orElseThrow(() -> new RecursoNaoEncontrado("TBEscala não encontrada."));
		return escala;						
	}
	
	public TBEscala2 alterar(Long idTBEscala, TBEscala2 tBEscala) {
		TBEscala2 escala = consultar(idTBEscala);
		validaCampos(tBEscala);
		escala.setOp2_21(tBEscala.getOp2_21());
		escala.setOp2_22(tBEscala.getOp2_22());
		escala.setOp2_23(tBEscala.getOp2_23());
		escala.setComentarioDM2(tBEscala.getComentarioDM2());
		escala.setSomaDM2(tBEscala.getSomaDM2());

		return repo.save(escala);
	}
	public void excluir(Long id) {
		TBEscala2 end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(TBEscala2 tBEscala) {
		if(tBEscala.getOp2_21() < 0 || tBEscala.getOp2_21() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp2_22() < 0 || tBEscala.getOp2_22() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp2_23() < 0 || tBEscala.getOp2_23() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getComentarioDM2().equals("")) {
			throw new ValidaDadosException("Você deve descrever algum comentário");
		}/* 
		if(tBEscala.getSomaDM1() <= DADOS DA SOMA(VALOR MAX E MIN) {
			throw new ValidaDadosException("O UF deve ser informado");
		}*/
	}
}
