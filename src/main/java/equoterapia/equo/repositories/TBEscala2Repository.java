package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.TBEscala2;

@Repository
public interface TBEscala2Repository extends JpaRepository<TBEscala2 ,Long>{

}