package Tienda.Tienda.controllers;

import Tienda.Tienda.entities.Usuario;
import Tienda.Tienda.service.impl.SignUpService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SignUpController {
    
    @Autowired
    private SignUpService loginService;
    
    @GetMapping("/registro")
    public String nuevo(Model model, Usuario usuario) {
        return "/registro";
    }
    
    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/registro/recordar";
    }
    
    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) throws MessagingException {
        model = loginService.crearUsuario(model, usuario);
        return "/registro/salida";
    }
    
    @GetMapping("/activacion/{usuario}/{id}")
    public String activar (Model model, @PathVariable(value = "usuario") String usuario, @PathVariable(value = "id") String id){
        model = loginService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }
    
    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario) throws MessagingException {
        model = loginService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }
    
}
