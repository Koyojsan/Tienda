package Tienda.Tienda.controllers;

import Tienda.Tienda.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final IProductService productService;

    public IndexController(IProductService productService) {
        this.productService = productService;
    }

    //Mapeo de index
    @GetMapping("/")
    public String index(Model model) {
        var productos = this.productService.getAll();
        model.addAttribute("products", productos);
        return "index";
    }
}