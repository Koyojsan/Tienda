package Tienda.Tienda.api;

import Tienda.Tienda.entities.Product;
import Tienda.Tienda.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("api/product")
public class ProductControllerAPI {
    private final IProductService productService;

    public ProductControllerAPI(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @GetMapping()
    public Product getById(@RequestParam("id") int id) {
        var product = this.productService.getById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody Product product) {
        this.productService.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}