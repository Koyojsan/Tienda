package Tienda.Tienda.controllers;

import Tienda.Tienda.entities.Product;
import Tienda.Tienda.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    //Get base de datos de los productos
    @GetMapping("/product")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", this.productService.getAllProducts());
        return "product";
    }
    //Guardar cambio
    @PostMapping("product/save")
    public String save(@ModelAttribute("product") Product product) {
        this.productService.save(product);
        return "redirect:/product";
    }
    //Borrar producto
    @PostMapping("product/delete")
    public ResponseEntity<String> delete(@RequestBody Product product) {
        this.productService.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}