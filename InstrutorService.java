package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Instrutor;
import equoterapia.equo.exceptions.RecursoJaExistente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	@Autowired
	InstrutorRepository repo;
	
	public Instrutor salvar(Instrutor instrutor) {
		/*validaCampos(instrutor);*/	
		if (repo.findById((long) instrutor.getId_instrutor()) != null) {
			throw new RecursoJaExistente("Instrutor já cadastrado para esse email");
		}	
		return repo.save(instrutor);
	}
	
	public Instrutor consultar(Long id) {
		Optional<Instrutor> opt = repo.findById(id);
		Instrutor cv = opt.orElseThrow(() -> new RecursoNaoEncontrado("Instrutor não encontrado."));
		return cv;						
	}
	
	public Instrutor alterar(Long idInstrutor, Instrutor instrutor) {
		Instrutor cv = consultar(idInstrutor);
		/*validaCampos(instrutor);*/
		cv.setNome_instrutor(instrutor.getNome_instrutor());
		cv.setCpf(instrutor.getCpf());
		cv.setData_nascimento_ins(instrutor.getData_nascimento_ins());
		cv.setEndereco_ins(instrutor.getEndereco_ins());
		cv.setNumero_instrutor(instrutor.getNumero_instrutor());
		cv.setSexo(instrutor.getSexo());
		return repo.save(cv);
	}
	public void excluir(Long id) {
		Instrutor cv = consultar(id);
		repo.delete(cv);
	}
	/*private void validaCampos(Instrutor instrutor) {
		if(instrutor.getNome_instrutor().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		
		if(instrutor.getCpf().equals("")) {
			throw new ValidaDadosException("O CPF deve ser informado");
		}
		
		if(instrutor.getData_nascimento_ins().equals(null)) {
		    throw new ValidaDadosException("A data de nascimento deve ser informada");
		}
		
		if(instrutor.getEndereco_ins().equals("")) {
			throw new ValidaDadosException("O endereço deve ser informado");
		}
		
		if(instrutor.getNumero_instrutor().equals("")) {
			throw new ValidaDadosException("O número deve ser informado");
		}
		
		if(instrutor.getSexo().equals("")) {
			throw new ValidaDadosException("O sexo deve ser informado");
		}
		
	}*/
}
