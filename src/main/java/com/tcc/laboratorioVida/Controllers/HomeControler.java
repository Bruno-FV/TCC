package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.laboratorioVida.Models.Contato;
import com.tcc.laboratorioVida.Repository.ContatoRepo;

@RestController
@RequestMapping("https://tcc-laboratorio-vida.netlify.app/")
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
