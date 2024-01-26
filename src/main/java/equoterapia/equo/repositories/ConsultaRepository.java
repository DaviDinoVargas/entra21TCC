package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
