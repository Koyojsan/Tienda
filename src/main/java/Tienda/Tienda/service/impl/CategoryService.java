package Tienda.Tienda.service.impl;

import Tienda.Tienda.db.ICategoryRepository;
import Tienda.Tienda.entities.Category;
import Tienda.Tienda.service.ICategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Integer> implements ICategoryService {
    public CategoryService(ICategoryRepository categoryRepository) {
        super(categoryRepository);
    }

}
