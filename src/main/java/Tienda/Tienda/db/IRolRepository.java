package Tienda.Tienda.db;

import Tienda.Tienda.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository <Rol, Long>{
    
}
