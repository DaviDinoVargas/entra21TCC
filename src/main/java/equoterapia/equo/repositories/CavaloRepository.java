package equoterapia.equo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import equoterapia.equo.entidades.Cavalo;

@Repository
public interface CavaloRepository extends JpaRepository<Cavalo, Long>{
}