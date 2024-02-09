package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Medico;
import equoterapia.equo.exceptions.RecursoJaExistente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.repositories.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository repo;
	
	public Medico salvar(Medico medico) {
		/*validaCampos(medico);*/	
		if (repo.findById((long) medico.getId_medico()) != null) {
			throw new RecursoJaExistente("Medico já cadastrado para esse email");
		}	
		return repo.save(medico);
	}
	
	public Medico consultar(Long id) {
		Optional<Medico> opt = repo.findById(id);
		Medico cv = opt.orElseThrow(() -> new RecursoNaoEncontrado("Medico não encontrado."));
		return cv;						
	}
	
	public Medico alterar(Long idMedico, Medico medico) {
		Medico cv = consultar(idMedico);
		/*validaCampos(medico);*/
		cv.setNome_medico(medico.getNome_medico());
		cv.setCpf(medico.getCpf());
		cv.setData_nascimento_med(medico.getData_nascimento_med());
		cv.setEndereco_med(medico.getEndereco_med());
		cv.setNumero_medico(medico.getNumero_medico());
		cv.setSexo(medico.getSexo());
		return repo.save(cv);
	}
	public void excluir(Long id) {
		Medico cv = consultar(id);
		repo.delete(cv);
	}
	/*private void validaCampos(Medico medico) {
		if(medico.getNome_medico().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		
		if(medico.getCpf().equals("")) {
			throw new ValidaDadosException("O CPF deve ser informado");
		}
		
		if(medico.getData_nascimento().equals(null)) {
		    throw new ValidaDadosException("A data de nascimento deve ser informada");
		}
		
		if(medico.getEndereco_med().equals("")) {
			throw new ValidaDadosException("O endereço deve ser informado");
		}
		
		if(medico.getNumero_medico().equals("")) {
			throw new ValidaDadosException("O número deve ser informado");
		}
		
		if(medico.getSexo().equals("")) {
			throw new ValidaDadosException("O sexo deve ser informado");
		}
		
	}*/
}
