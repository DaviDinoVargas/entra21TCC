package equoterapia.equo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Consulta;
import equoterapia.equo.entidades.Paciente;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	List<Consulta> findByPaciente(Paciente paciente);
}
