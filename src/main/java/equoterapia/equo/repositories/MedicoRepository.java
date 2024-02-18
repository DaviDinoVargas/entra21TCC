package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long>{

}