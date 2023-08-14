package Tienda.Tienda.db;

import Tienda.Tienda.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository <Factura, Long> {
    
}
