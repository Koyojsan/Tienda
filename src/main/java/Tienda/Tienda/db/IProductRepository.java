package Tienda.Tienda.db;

import Tienda.Tienda.entities.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Mapea Producto (Entity)
public interface IProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByPrecioBetween(int lowerPrice, int higherPrice);
    List<Product> findAllByPrecioGreaterThanEqual(int lowerPrice);
    List<Product> findAllByPrecioIsLessThanEqual(int HigherPrice);
}
//this will work as a sorting of prices