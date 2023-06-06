package com.tcc.laboratorioVida.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.laboratorioVida.Models.CadastroLogin;
import com.tcc.laboratorioVida.Repository.CadLoginRepo;
import com.tcc.laboratorioVida.Repository.Criptografia;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

  @Autowired
  private CadLoginRepo cadLoginRepo;

  @GetMapping("/login")
  public String login(HttpSession session, HttpServletRequest request) {
    session = request.getSession(false);
    if (session != null && session.getAttribute("secaoIniciada") != null) {
      return "redirect:/arealogin";// A sessão está ativa e o usuário está logado.
    } else {
      return "Paginas/login";// A sessão não está ativa ou o usuário não está logado.
    }

  }

  @PostMapping("/validar")
  public String validar(CadastroLogin confirmar, HttpSession session,
      RedirectAttributes aviso) {
        
    CadastroLogin confirmacao = this.cadLoginRepo.login(confirmar.getEmail(),
        Criptografia.md5cripto(confirmar.getSenha()));
    if (confirmacao != null) {
         
      session.setAttribute("secaoIniciada", confirmacao);
      session.setMaxInactiveInterval(60*60);
      
      return "redirect:/arealogin";
    } else {
      aviso.addFlashAttribute("mensagem", "Email ou senha inválidos, tente novamente");
      return "redirect:/login";
    }

  }

  @PostMapping("/logout")
  public String logout(HttpSession session, HttpServletResponse response) {
    session.invalidate();
    return "redirect:/login";
  }
}
