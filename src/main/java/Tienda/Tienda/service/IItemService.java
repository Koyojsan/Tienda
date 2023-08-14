package Tienda.Tienda.service;

import Tienda.Tienda.entities.Item;
import java.util.ArrayList;
import java.util.List;

public interface IItemService {
    
    //Para no usar la BD se usa un ArrayList para que los items se guarden temporalmente
    public List<Item> listaItems = new ArrayList<>();
    
    public List<Item> getItems();
    
    //Si el objeto item tiene un idItem que existe en la tabla item
    //El registro de actualiza con la nueva información​
    //Si el idItem NO existe en la tabla, se crea el registro con esa información
    public void save(Item item);
    
    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Item item);
    
    //Se recupera el registro que tiene el idItem pasado por parámetro​
    //si no existe en la tabla se retorna null
    public Item getItem(Item item);
    
    public void actualiza(Item item);
    
    public void facturar();
}
