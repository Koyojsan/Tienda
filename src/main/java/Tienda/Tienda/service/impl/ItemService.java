package Tienda.Tienda.service.impl;

import Tienda.Tienda.entities.Item;
import Tienda.Tienda.service.IItemService;
import Tienda.Tienda.entities.Factura;
import Tienda.Tienda.db.IVentaRepository;
import Tienda.Tienda.entities.Product;
import Tienda.Tienda.entities.Usuario;
import Tienda.Tienda.entities.Venta;
import Tienda.Tienda.service.IUserDetailService;
import Tienda.Tienda.service.IItemService;
import Tienda.Tienda.controllers.ProductController;
import Tienda.Tienda.db.IFacturaRepository;
import Tienda.Tienda.db.IProductRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@Service
public class ItemService implements IItemService {
    
    @Override
    public List<Item> getItems() {
        return listaItems;
    }
    
    //En el addCarrito añadimos un elemento
    @Override
    public void save (Item item){
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si existe el articulo en el carrito
            if (Objects.equals(i.getId(), item.getId())) {
                //Es para validar si se pueden añadir mas articulos adicionales
                if (i.getCantidad() < i.getExistencias()) {
                    //Incrementa 1 cantidad mas a los elementos
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {
            //Si no está el articulo en el carrito, entonces lo agrega en cantidad = 1
            item.setCantidad(1);
            listaItems.add(item);
        }
    }
    
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getId(), item.getId())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }
    
    @Override
    public Item getItem(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getId(), item.getId())) {
                return i;
            }
        }
        return null;
    }
    
    //Se usa en la pagina para actualizar la cantidad de productos
    @Override
    public void actualiza (Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getId(), item.getId())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }
    
    @Autowired
    private IUserDetailService userService;
    
    @Autowired
    private IFacturaRepository facturaRepository;
    
    @Autowired
    private IVentaRepository ventaRepository;
    
    @Autowired
    private IProductRepository productRepository;
    
    //Esto funcionará para una futura facturación por por el momento (Semana 12) borra artiulos del carrito
    @Override
    public void facturar(){
        System.out.println("Facturando");
        //Se obtiene un usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetail) {
            username = userDetail.getUsername();
        } else {
            username = principal.toString();
        }
        if (username.isBlank()) {
            return;
        }
        Usuario usuario =  userService.getUsuarioPorUsername(username);
        if (usuario == null) {
            return;
        }
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaRepository.save(factura);
        double total = 0;     
        for (Item i : listaItems) {
            //Esto es para facturar
            System.out.println("Producto: " + i.getDescripcion() 
                    + "Cantidad: " + i.getCantidad()
                    + "Total: " +  i.getPrecio() * i.getCantidad());
            
            Venta venta = new Venta(factura.getIdFactura(), i.getId(), i.getPrecio(), i.getCantidad());
            ventaRepository.save(venta); 
            Product producto = productRepository.getReferenceById(i.getId());
            producto.setExistencias(producto.getExistencias()-i.getCantidad());
            productRepository.save(producto);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaRepository.save(factura);       
        listaItems.clear();
    }
}
