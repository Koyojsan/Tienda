package Tienda.Tienda.service.impl;

import Tienda.Tienda.db.IProductRepository;
import Tienda.Tienda.entities.Item;
import Tienda.Tienda.entities.Product;
import Tienda.Tienda.service.IProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends BaseService<Product, Integer> implements IProductService {
    //here we have to create this variable because of syntax we can't see the this.repository as a IproductRepository
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public List<Product> getProductsWithFilters(Optional<Integer> lowerPrice, Optional<Integer> higherPrice) {
        if (lowerPrice.isPresent() && higherPrice.isPresent()) {
            return this.productRepository.findAllByPrecioBetween(lowerPrice.get(), higherPrice.get());
        }

        if (lowerPrice.isPresent()) {
            return this.productRepository.findAllByPrecioGreaterThanEqual(lowerPrice.get());
        }

        if (higherPrice.isPresent()) {
            return this.productRepository.findAllByPrecioIsLessThanEqual(higherPrice.get());
        }

        return (List<Product>) this.productRepository.findAll();
    }
    //Obtener los productos?

    @Override
    public Product getProduct(Item item) {
        //OBVIO ESTO NO SE HACE, ES POR AHORA
        throw new UnsupportedOperationException("Not supported yet.");
    }
}