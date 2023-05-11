package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.laboratorioVida.Models.CadastroLogin;
import com.tcc.laboratorioVida.Repository.CadLoginRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CadastroLoginController {

    @Autowired
    private CadLoginRepo cadLoginRepo;

    @GetMapping("/cadastroLogin")
    public String cadLogin() {
        return "Paginas/cadastroLogin";
    }

    @PostMapping("/verificarEmail")
    public String verificarEmail(CadastroLogin cadastroLogin, CadastroLogin confirmarEmail,
            RedirectAttributes aviso, HttpSession session) {
        CadastroLogin confirmacaoEmail = this.cadLoginRepo.verificarEmail(confirmarEmail.getEmail());
        if (confirmacaoEmail != null) {
            aviso.addFlashAttribute("mensagem", "Email já cadastrado, efetue login.");
            return "redirect:/login";
        } else {
            cadLoginRepo.save(cadastroLogin);
            session.setAttribute("secaoIniciada", cadastroLogin);
            return "redirect:/arealogin";
        }

    }
}
