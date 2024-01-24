package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import entidades.Usuario;


@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    UserDetails findByEmpresa(String empresa);
}