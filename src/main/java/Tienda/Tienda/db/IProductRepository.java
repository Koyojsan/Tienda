package Tienda.Tienda.db;

import Tienda.Tienda.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository <Product, Integer> {
    List<Product> findAllByPrecioBetween(int lowerPrice, int higherPrice);
    List<Product> findAllByPrecioGreaterThanEqual(int lowerPrice);
    List<Product> findAllByPrecioIsLessThanEqual(int HigherPrice);
}
//this will work as a sorting of prices