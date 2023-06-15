package Tienda.Tienda.db;
import Tienda.Tienda.entities.Product;
import org.springframework.data.repository.CrudRepository;
public interface IProductRepository extends CrudRepository<Product, Integer> {
}
