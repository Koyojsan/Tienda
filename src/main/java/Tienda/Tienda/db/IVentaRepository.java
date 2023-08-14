package Tienda.Tienda.db;

import Tienda.Tienda.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository <Venta, Long> {
    
}
