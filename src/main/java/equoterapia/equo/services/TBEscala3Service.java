package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.entidades.TBEscala3;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.TBEscala3Repository;

@Service
public class TBEscala3Service {
	@Autowired
	TBEscala3Repository repo;
	
	public TBEscala3 salvar(TBEscala3 tBEscala) {
		//validaCampos(tBEscala);	
		
		return repo.save(tBEscala);
	}
	
	public TBEscala3 consultar(Long id) {
		Optional<TBEscala3> opt = repo.findById(id);
		TBEscala3 escala = opt.orElseThrow(() -> new RecursoNaoEncontrado("TBEscala não encontrada."));
		return escala;						
	}
	
	public TBEscala3 alterar(Long idTBEscala, TBEscala3 tBEscala) {
		TBEscala3 escala = consultar(idTBEscala);
		validaCampos(tBEscala);
		escala.setOp3_1(tBEscala.getOp3_1());
		escala.setOp3_2(tBEscala.getOp3_2());
		escala.setOp3_3(tBEscala.getOp3_3());
		escala.setOp3_3(tBEscala.getOp3_4());
		escala.setOp3_3(tBEscala.getOp3_5());
		escala.setOp3_3(tBEscala.getOp3_6());
		escala.setOp3_3(tBEscala.getOp3_7());
		escala.setOp3_3(tBEscala.getOp3_8());
		escala.setComentarioDM3(tBEscala.getComentarioDM3());
		escala.setSomaDM3(tBEscala.getSomaDM3());

		return repo.save(escala);
	}
	public void excluir(Long id) {
		TBEscala3 end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(TBEscala3 tBEscala) {
		if(tBEscala.getOp3_1() < 0 || tBEscala.getOp3_1() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp3_2() < 0 || tBEscala.getOp3_2() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp3_3() < 0 || tBEscala.getOp3_3() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getComentarioDM3().equals("")) {
			throw new ValidaDadosException("Você deve descrever algum comentário");
		}/* 
		if(tBEscala.getSomaDM1() <= DADOS DA SOMA(VALOR MAX E MIN) {
			throw new ValidaDadosException("O UF deve ser informado");
		}*/
	}
}