package com.tcc.laboratorioVida.Controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcc.laboratorioVida.Models.CadastroLogin;
import com.tcc.laboratorioVida.Repository.CadConsultasRepo;
import com.tcc.laboratorioVida.Repository.CadExamesRepo;
import com.tcc.laboratorioVida.Repository.CadLoginRepo;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class AreaLoginController {

    @Autowired
    private CadLoginRepo cadLoginRepo;
    @Autowired
    CadConsultasRepo consultasRepo;
    @Autowired
    CadExamesRepo examesRepo;

    @GetMapping("/arealogin")
    public String arealogin(HttpServletResponse response, HttpSession session,
            HttpServletRequest request, Model model) {
         
                ArrayList especialidadeMedicoas = (ArrayList) consultasRepo.findAll(); 
                model.addAttribute("especialidadeMedicoas", especialidadeMedicoas);

                Iterable tiposExames =  examesRepo.findAll(); 
                model.addAttribute("tiposExames", tiposExames);
                
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
