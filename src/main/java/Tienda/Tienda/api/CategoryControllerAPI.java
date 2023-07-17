package Tienda.Tienda.api;

import Tienda.Tienda.entities.Category;
import Tienda.Tienda.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("api/category")
public class CategoryControllerAPI {
    private final ICategoryService categoryService;

    public CategoryControllerAPI(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping()
    public Category getById(@RequestParam("id") int id) {
        var category = this.categoryService.getById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping()
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody Category category) {
        this.categoryService.delete(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}