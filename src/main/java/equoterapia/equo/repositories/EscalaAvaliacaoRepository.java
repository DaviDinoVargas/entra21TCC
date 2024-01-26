package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.EscalaAvaliacao;

@Repository
public interface EscalaAvaliacaoRepository extends JpaRepository<EscalaAvaliacao, Long>{

}
