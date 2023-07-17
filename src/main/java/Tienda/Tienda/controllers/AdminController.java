package Tienda.Tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public AdminController() {
    }

    @GetMapping()
    public String index() {
        return "admin";
    }
}