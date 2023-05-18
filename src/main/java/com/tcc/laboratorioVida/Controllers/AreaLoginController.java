package com.tcc.laboratorioVida.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AreaLoginController {

    @GetMapping("/arealogin")
    public String arealogin(HttpServletResponse response, HttpSession session,
            HttpServletRequest request) {
        final String cacheControl = "Cache-Control";
        response.setHeader(cacheControl, "no-cache, no-store, must-revalidate");
        response.setHeader(cacheControl, "no-cache");
        response.setHeader(cacheControl, "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        session = request.getSession(false);
        if (session != null && session.getAttribute("secaoIniciada") != null) {
            return "Paginas/arealogin";// A sessão está ativa e o usuário está logado.
        } else {

            return "redirect:/login";// A sessão não está ativa ou o usuário não está logado.
        }

    }

}
