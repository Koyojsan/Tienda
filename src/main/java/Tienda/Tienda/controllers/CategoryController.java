
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

    @GetMapping("/category")
    public String index(Model model) {
        model.addAttribute("categoryDefault", new Category());
        model.addAttribute("categories", this.categoryService.getAll());
        return "category";
    }
    
//    @GetMapping("/listado")
//    public String page(Model model) {
//        log.info("Consumo del recurso /categoria/listado");
//        List<Category> categorias = categoryService.getCategory(false);
//        //List<Categoria> categorias = categoriaService.getPorDescripcion("Sillas Gamer");
//        model.addAttribute("categorias", categorias);
//        model.addAttribute("totalCategorias", categorias.size());
//        return "/categoria/listado";
//    }
//    
//    @GetMapping("/nuevo")
//    public String categoriaNuevo(Categoria categoria) {
//        return "/categoria/modifica";
//    }    
//    
//    @PostMapping("/guardar")
//    public String categoriaGuardar(Categoria categoria,
//            @RequestParam("imagenFile") MultipartFile imagenFile) {
//        if (!imagenFile.isEmpty()) {
//            categoriaService.save(categoria);
//            categoria.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "categoria", 
//                            categoria.getIdCategoria()));
//        }
//        categoriaService.save(categoria);
//        return "redirect:/categoria/listado";
//    }
//
//    @GetMapping("/eliminar/{idCategoria}")
//    public String categoriaEliminar(Categoria categoria) {
//        categoriaService.delete(categoria);
//        return "redirect:/categoria/listado";
//    }
//
//    @GetMapping("/modificar/{idCategoria}")
//    public String categoriaModificar(Categoria categoria, Model model) {
//        categoria = categoriaService.getCategoria(categoria);
//        model.addAttribute("categoria", categoria);
//        return "/categoria/modifica";
//    }

}