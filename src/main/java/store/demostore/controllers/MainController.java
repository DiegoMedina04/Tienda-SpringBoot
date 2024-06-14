package store.demostore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String presentation() {
        return "Esta es la página principal de la tienda.";
    }

}
