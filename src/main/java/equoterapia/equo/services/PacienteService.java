package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Paciente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository repo;
	
	public Paciente salvar(Paciente paciente) {
		//validaCampos(paciente);	
		/*if (repo.findByCpf(paciente.getCpf()) != null) {
			throw new RecursoJaExistente("Paciente já cadastrado para esse cpf");
		}	*/
		return repo.save(paciente);
	}
	
	public Paciente consultar(Long id) {
		Optional<Paciente> opt = repo.findById(id);
		Paciente pc = opt.orElseThrow(() -> new RecursoNaoEncontrado("Paciente não encontrado."));
		return pc;						
	}
	
	public Paciente alterar(Long idPaciente, Paciente paciente) {
		Paciente pc = consultar(idPaciente);
		//validaCampos(paciente);
		pc.setNome_paciente(paciente.getNome_paciente());
		pc.setData_nascimento(paciente.getData_nascimento());
		pc.setCpf(paciente.getCpf());
		pc.setEmail_paciente(paciente.getEmail_paciente());
		pc.setSexo(paciente.getSexo());
		return repo.save(pc);
	}
	public void excluir(Long id) {
		Paciente pc = consultar(id);
		repo.delete(pc);
	}
	private void validaCampos(Paciente paciente) {
		if(paciente.getNome_paciente().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		if(paciente.getEmail_paciente().equals("")) {
			throw new ValidaDadosException("O email deve ser informado");
		}
		if(paciente.getCpf().equals("")) {
			throw new ValidaDadosException("O cpf deve ser informado");
		}
		if(paciente.getSexo().equals("")) {
			throw new ValidaDadosException("O sexo deve ser informado");
		}
		/*if(paciente.getIdade_paciente() <= 0) {
		    throw new ValidaDadosException("A idade deve ser informada e maior que zero");
		}*/
	}
}
