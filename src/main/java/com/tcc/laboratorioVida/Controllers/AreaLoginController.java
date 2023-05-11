package com.tcc.laboratorioVida.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AreaLoginController {

    @GetMapping("/arealogin")
    public String arealogin() {

        return "Paginas/arealogin";
    }
}
