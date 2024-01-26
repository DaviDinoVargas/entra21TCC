package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	UserDetails findByCpf(String cpf);
}
