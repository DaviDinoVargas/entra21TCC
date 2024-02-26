package equoterapia.equo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.TBEscala1;

@Repository
public interface TBEscala1Repository extends JpaRepository<TBEscala1, Long> {
    List<TBEscala1> findByCpfPaciente(String cpfPaciente);
}