package equoterapia.equo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Cavalo;
import equoterapia.equo.entidades.Paciente;

@Repository
public interface CavaloRepository extends JpaRepository<Cavalo, Long>{

}
