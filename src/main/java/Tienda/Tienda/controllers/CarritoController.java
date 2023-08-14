package Tienda.Tienda.controllers;

import Tienda.Tienda.entities.Item;
import Tienda.Tienda.entities.Product;
import Tienda.Tienda.service.IItemService;
import Tienda.Tienda.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {
    
    @Autowired
    private IItemService itemService;
    
    @Autowired
    private IProductService productService;
    
    //Esto es para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.getItems();
        model.addAttribute("items",items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());          
        }   
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }
    
    //Esto es para agregar un articulo al carrito
    @GetMapping("/carrito/agregar/{id_producto}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.getItem(item);
        if (item2 == null) {
            Product product = productService.getProduct(item);
            item2 = new Item(product);
        }
        itemService.save(item2);
        var lista = itemService.getItems();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal",totalCarritos);
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }
    
    //Esto para modificar un articulo del carrito
    @GetMapping("/carrito/modificar/{id_producto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.getItem(item);
        model.addAttribute("item",item);
        return "/carrito/modificar";
    }
    
    //Esto para eliminar articulos del carrito
    @GetMapping("/carrito/eliminar/{id_producto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }
    
    //Esto para actualizar articulos del carrito
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
    
    //Esto para facturar articulos del carrito...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}
