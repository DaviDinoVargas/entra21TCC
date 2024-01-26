package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
