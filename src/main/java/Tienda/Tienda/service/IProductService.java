package Tienda.Tienda.service;

import Tienda.Tienda.entities.Item;
import Tienda.Tienda.entities.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService extends IBaseService<Product, Integer> {
    List<Product> getProductsWithFilters(Optional<Integer> lowerPrice, Optional<Integer> higherPrice);
    //Barra de busqueda
    
    public Product getProduct(Item item);
    //Este metodo lo pongo por varas, aun no se si realmente funciona
}
