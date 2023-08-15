package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcc.laboratorioVida.Models.Contato;
import com.tcc.laboratorioVida.Repository.ContatoRepo;

@Controller
public class HomeControler {
    @Autowired
    private ContatoRepo contatoRepo;

    @GetMapping("/home")
    public String home(Model model) {
        
/**************************Buscar todos os Contatos ********************************************/
    Iterable<Contato>contato = contatoRepo.findAll();
    model.addAttribute("contatos", contato);
        return "Paginas/home";
    }
  
    
}
