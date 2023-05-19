package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.laboratorioVida.Models.CadastroAdmin;

import com.tcc.laboratorioVida.Repository.CadAdminRepo;
import com.tcc.laboratorioVida.Repository.Criptografia;

import jakarta.servlet.http.HttpSession;

@Controller
public class CadastroAdminController {
    @Autowired
    private CadAdminRepo cadAdminRepo;
    
    @GetMapping("/cadastro_usuario_admin")
    public String cadastroAdmin() {
        return "Paginas/cadastrologinAdmin";
    }


    @PostMapping("/cadastro/salvar_bd")
    public String salvarAdmin(CadastroAdmin emailUser,CadastroAdmin cadastroAdmin, HttpSession session,RedirectAttributes alerta){
        CadastroAdmin autenticaremail = this.cadAdminRepo.verificarEmailAdmin(emailUser.getEmail());
        if(autenticaremail != null){
            alerta.addFlashAttribute("mensagem", "Email já cadastrado, efetue login.");
            return "redirect:/loginAdmin";
        }else{
            cadastroAdmin.setSenha(Criptografia.md5cripto(cadastroAdmin.getSenha()));
            cadAdminRepo.save(cadastroAdmin);
            session.setAttribute("secaoAdminIniciada", cadastroAdmin);
        return "redirect:/administracao";
        }
        
    }
}
