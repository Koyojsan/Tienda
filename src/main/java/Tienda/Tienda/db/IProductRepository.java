//Interfaz

package Tienda.Tienda.db;
import Tienda.Tienda.entities.Product;
import org.springframework.data.repository.CrudRepository;

//Mapea Producto (Entity)
public interface IProductRepository extends CrudRepository<Product, Integer> {
}
