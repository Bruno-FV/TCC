package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.laboratorioVida.Models.CadastroAdmin;

import com.tcc.laboratorioVida.Repository.CadAdminRepo;
import com.tcc.laboratorioVida.Repository.Criptografia;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginAdminController {
    @Autowired
    private CadAdminRepo cadAdminRepo;

    @GetMapping("/loginAdmin")
    public String loginAdm(){
        return "Paginas/loginAdmin";
    }

    @PostMapping("/validarAdmin")
    public String autenticacaoAdmin(CadastroAdmin autenticar,HttpSession session,
    RedirectAttributes alerta){
        
        CadastroAdmin validar = this.cadAdminRepo.loginAdmin(autenticar.getEmail(),Criptografia.md5cripto(autenticar.getSenha()));
        if(validar != null){
            session.setAttribute("secaoAdminIniciada", validar);
            session.setMaxInactiveInterval(60*60);
            return "redirect:/administracao";
        }else{
            alerta.addFlashAttribute("mensagem", "Email ou senha inválidos, tente novamente");
            return "redirect:/loginAdmin";
        }
        
    }
    @PostMapping("/logoutAdmin")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        return "redirect:/loginAdmin";
  }
    
}
