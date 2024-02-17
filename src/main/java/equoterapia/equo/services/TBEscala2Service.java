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
		//validaCampos(tBEscala);	
		
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
		escala.setOp2_1(tBEscala.getOp2_1());
		escala.setOp2_2(tBEscala.getOp2_2());
		escala.setOp2_3(tBEscala.getOp2_3());
		escala.setOp2_3(tBEscala.getOp2_4());
		escala.setOp2_3(tBEscala.getOp2_5());
		escala.setOp2_3(tBEscala.getOp2_6());
		escala.setOp2_3(tBEscala.getOp2_7());
		escala.setOp2_3(tBEscala.getOp2_8());
		escala.setComentarioDM2(tBEscala.getComentarioDM2());
		escala.setSomaDM2(tBEscala.getSomaDM2());
		escala.setCpf_paciente(tBEscala.getCpf_paciente());

		return repo.save(escala);
	}
	public void excluir(Long id) {
		TBEscala2 end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(TBEscala2 tBEscala) {
		if(tBEscala.getOp2_1() < 0 || tBEscala.getOp2_1() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp2_2() < 0 || tBEscala.getOp2_2() > 4) {
			throw new ValidaDadosException("A Avaliação é somente de 0 a 4");
		}
		if(tBEscala.getOp2_3() < 0 || tBEscala.getOp2_3() > 4) {
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