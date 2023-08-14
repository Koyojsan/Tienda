package Tienda.Tienda.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Product{
    public int cantidad; //Almacenar la cantidad de items de un articulo
    
    public Item(){
    }
    
    public Item(Product product){
        super.setId(product.getId());
        super.setCategory(product.getCategory());
        super.setDescripcion(product.getDescripcion());
        super.setDetalle(product.getDetalle());
        super.setPrecio(product.getPrecio());
        super.setExistencias(product.getExistencias());
        super.setRuta_imagen(product.getRuta_imagen());
        super.setActivo(product.isActivo());
        this.cantidad = 0;
    }
    
    public int getItemCantidad(){
        return cantidad;
    }
    
    public void setItemCantidad(){
        this.cantidad = cantidad;
    }
}
