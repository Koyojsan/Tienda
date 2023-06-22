package Tienda.Tienda.service;

import Tienda.Tienda.entities.Product;
import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    void save(Product product);

    void delete(Product product);
}
