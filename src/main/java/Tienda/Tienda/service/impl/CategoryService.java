package Tienda.Tienda.service.impl;

import Tienda.Tienda.db.ICategoryRepository;
import Tienda.Tienda.entities.Category;
import Tienda.Tienda.service.ICategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService extends BaseService<Category, Integer> implements ICategoryService {
    public CategoryService(ICategoryRepository categoryRepository){
        super(categoryRepository);
    }
//    @Autowired
//    ICategoryRepository categoryRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public List <Category> getCategorias(boolean activos) {
//        List <Category> categorias = categoryRepository.findAll();
//        if (activos) {
//            categorias.removeIf(x -> !x.isActivo());
//        }
//        return categorias;
//    }
//    
//    @Override
//    @Transactional(readOnly = true)
//    public Category getCategoria(Category categoria) {
//        return categoryRepository.findById(categoria.getId()).orElse(null);
//    }
//
//    @Override
//    @Transactional
//    public void save(Category categoria) {
//        categoryRepository.save(categoria);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Category categoria) {
//        categoryRepository.delete(categoria);
//    }
//
//    @Override
//    public List<Category> getPorDescripcion(String descripcion) {
//        return categoryRepository.findByDescripcion(descripcion);
//    }
}
