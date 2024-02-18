package equoterapia.equo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.entidades.TBEscala3;

@Repository
public interface TBEscala3Repository extends JpaRepository<TBEscala3 ,Long>{
	List<TBEscala3> findByCpfPaciente(String cpfPaciente);
}