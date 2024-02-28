package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Cavalo;
import equoterapia.equo.entidades.Consulta;
import equoterapia.equo.entidades.Medico;
import equoterapia.equo.entidades.Paciente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.CavaloRepository;
import equoterapia.equo.repositories.ConsultaRepository;
import equoterapia.equo.repositories.MedicoRepository;
import equoterapia.equo.repositories.PacienteRepository;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository repo;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	CavaloRepository cavaloRepository;
	
	public Consulta salvar(Consulta consulta) {
		//validaCampos(consulta);	
		//if (repo.findById((long) consulta.getIdConsulta()) != null) {
		//	throw new RecursoJaExistente("Consulta já cadastrada");
		//}
		Optional<Cavalo> cavalo = cavaloRepository.findById((long) consulta.getCavalo().getId_cavalo());
		consulta.setCavalo(cavalo.get());
		Optional<Paciente> paciente = pacienteRepository.findById(consulta.getPaciente().getId_paciente());
		consulta.setPaciente(paciente.get());
		Optional<Medico> medico = medicoRepository.findById((long) consulta.getMedico().getId_medico());
		consulta.setMedico(medico.get());
		
		return repo.save(consulta);
	}
	
	public Consulta consultar(Long id) {
		Optional<Consulta> opt = repo.findById(id);
		Consulta cons = opt.orElseThrow(() -> new RecursoNaoEncontrado("Consulta não encontrada."));
		return cons;						
	}
	
	public Consulta alterar(Long idConsulta, Consulta consulta) {
		Consulta cons = consultar(idConsulta);
		//validaCampos(consulta);
		cons.setCondicaoSaude(consulta.getCondicaoSaude());
		cons.setDataAvaliacao(consulta.getDataAvaliacao());
		cons.setEncilhamento(consulta.getEncilhamento());
		//cons.setCavalo(consulta.getCavalo());
		cons.setLocal(consulta.getLocal());
		//cons.setMedico(consulta.getMedico());
		cons.setHora(consulta.getHora());

		return repo.save(cons);
	}
	public void excluir(Long id) {
		Consulta end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(Consulta consulta) {
	    if (consulta.getCondicaoSaude() == null || consulta.getCondicaoSaude().isEmpty()) {
	        throw new ValidaDadosException("A condição de saúde deve ser informada");
	    }
	    if (consulta.getHora() == null) {
	        throw new ValidaDadosException("A hora deve ser informada");
	    }
	   // if (consulta.getDataAvaliacao() == null || consulta.getDataAvaliacao().isEmpty()) {
	   //     throw new ValidaDadosException("A data de avaliação deve ser informada");
	   // }
	    if (consulta.getEncilhamento() == null || consulta.getEncilhamento().isEmpty()) {
	        throw new ValidaDadosException("O encilhamento deve ser informado");
	    }
	}

	}