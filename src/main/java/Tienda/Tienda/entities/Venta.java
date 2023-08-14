package Tienda.Tienda.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="Venta")
public class Venta implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;
    private Long idFactura;
    private Integer idProducto;
    private double precio;
    private int cantidad;
    
    public Venta(){
    }
    
    public Venta(Long idFactura, Integer idProducto, double precio, int cantidad){
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public Long getIdVenta(){
        return idVenta;
    }
    
    public void setIdVenta(Long Venta){
        this.idVenta = idVenta;
    }
    
    public Long getIdFactura(){
        return idFactura;
    }
    
    public void setIdFactura(Long idFactura){
        this.idFactura = idFactura;
    }
    
    public Integer getIdProducto(){
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto){
        this.idProducto = idProducto;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int Cantidad){
        this.cantidad = cantidad;
    }
}
