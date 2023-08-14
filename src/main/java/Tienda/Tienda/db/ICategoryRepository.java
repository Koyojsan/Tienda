package Tienda.Tienda.db;

import Tienda.Tienda.entities.Category;
import org.springframework.data.repository.CrudRepository;

//Mapea Categoria (Entity)
public interface ICategoryRepository extends CrudRepository<Category, Integer> {
    //Metodo para encontrar por Descripcion
}
