package com.tcc.laboratorioVida.Controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.tcc.laboratorioVida.Models.CadastroConsultas;
import com.tcc.laboratorioVida.Models.CadastroExames;
import com.tcc.laboratorioVida.Repository.CadConsultasRepo;
import com.tcc.laboratorioVida.Repository.CadExamesRepo;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
public class AreaAdminController {
    @Autowired
    CadConsultasRepo consultasRepo;

    @Autowired
    CadExamesRepo examesRepo;
    
    @GetMapping("/administracao")
    public String administracao(HttpServletResponse response, HttpSession session,
    HttpServletRequest request, Model model){
        
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
        if (session != null && session.getAttribute("secaoAdminIniciada") != null) {
            return "Paginas/areaAdmin";// A sessão está ativa e o usuário está logado.
        } else {

            return "redirect:/loginAdmin";// A sessão não está ativa ou o usuário não está logado.
        } 
        
    }
    @PostMapping("/adicionarConsultas")
    public String cadConsultas(CadastroConsultas consultas){
        consultasRepo.save(consultas);
        return "redirect:/administracao";
    }
    @PostMapping("/adcionarExames")
    public String cadExames(CadastroExames exames){
        examesRepo.save(exames);
        return "redirect:/administracao";
    }
}
