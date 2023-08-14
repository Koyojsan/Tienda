package Tienda.Tienda.db;

import Tienda.Tienda.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {

}
