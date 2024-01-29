package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{

}