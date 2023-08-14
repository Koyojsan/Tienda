
package Tienda.Tienda.controllers;

import Tienda.Tienda.entities.Category;
import Tienda.Tienda.service.ICategoryService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Mapeo para category
    @GetMapping("/category")
    public String index(Model model) {
        model.addAttribute("categoryDefault", new Category());
        model.addAttribute("categories", this.categoryService.getAll());
        return "category";
    }
}