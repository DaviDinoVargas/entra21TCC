package equoterapia.equo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.TBEscala1;
import equoterapia.equo.entidades.TBEscala2;

@Repository
public interface TBEscala2Repository extends JpaRepository<TBEscala2 ,Long>{
	List<TBEscala2> findByCpfPaciente(String cpfPaciente);
}