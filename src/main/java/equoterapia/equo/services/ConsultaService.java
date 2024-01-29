package equoterapia.equo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equoterapia.equo.entidades.Consulta;
import equoterapia.equo.exceptions.RecursoJaExistente;
import equoterapia.equo.exceptions.RecursoNaoEncontrado;
import equoterapia.equo.exceptions.ValidaDadosException;
import equoterapia.equo.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository repo;
	
	public Consulta salvar(Consulta consulta) {
		validaCampos(consulta);	
		if (repo.findById((long) consulta.getIdConsulta()) != null) {
			throw new RecursoJaExistente("Consulta já cadastrada");
		}
		return repo.save(consulta);
	}
	
	public Consulta consultar(Long id) {
		Optional<Consulta> opt = repo.findById(id);
		Consulta cons = opt.orElseThrow(() -> new RecursoNaoEncontrado("Consulta não encontrada."));
		return cons;						
	}
	
	public Consulta alterar(Long idConsulta, Consulta consulta) {
		Consulta cons = consultar(idConsulta);
		validaCampos(consulta);
		cons.setCondicaoSaude(consulta.getCondicaoSaude());
		cons.setDataAvaliacao(consulta.getDataAvaliacao());
		cons.setEncilhamento(consulta.getEncilhamento());
		cons.setGuia(consulta.getGuia());
		cons.setHora(consulta.getHora());

		return repo.save(cons);
	}
	public void excluir(Long id) {
		Consulta end = consultar(id);
		repo.delete(end);
	}
	private void validaCampos(Consulta consulta) {
		if(consulta.getCondicaoSaude().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(consulta.getHora() == null) {
			throw new ValidaDadosException("O CEP deve ser informado");
		}
		if(consulta.getDataAvaliacao().equals("")) {
			throw new ValidaDadosException("A CIDADE deve ser informado");
		}
		if(consulta.getEncilhamento().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
		if(consulta.getGuia().equals("")) {
			throw new ValidaDadosException("O UF deve ser informado");
		}
	}
}