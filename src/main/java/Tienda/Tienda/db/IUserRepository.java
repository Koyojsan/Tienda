package Tienda.Tienda.db;

import Tienda.Tienda.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String Username);
}
