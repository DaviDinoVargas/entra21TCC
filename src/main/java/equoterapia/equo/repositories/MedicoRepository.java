package equoterapia.equo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Medico;
import equoterapia.equo.entidades.Paciente;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long>{
	Optional<Medico> findByNome(String nome);

}