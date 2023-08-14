package Tienda.Tienda.api;

import Tienda.Tienda.entities.Usuario;
import Tienda.Tienda.service.IUserDetailService;
import java.util.List;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/user")
public class UserControllerAPI {
    private final IUserDetailService userService;
    
    public UserControllerAPI(IUserDetailService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/all")
    public List<Usuario> getUsuarios() {
        return this.userService.getAll();
    }

    @GetMapping()
    public Usuario getById(@RequestParam("idUsuario") int id) {
        var usuario = this.userService.getById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @PostMapping()
    public Usuario save(@RequestBody Usuario usuario) {
        return this.userService.save(usuario);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestBody Usuario usuario) {
        this.userService.delete(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
