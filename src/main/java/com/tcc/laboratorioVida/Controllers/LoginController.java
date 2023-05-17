package com.tcc.laboratorioVida.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcc.laboratorioVida.Models.CadastroLogin;
import com.tcc.laboratorioVida.Repository.CadLoginRepo;
import com.tcc.laboratorioVida.Repository.Criptografia;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

  @Autowired
  private CadLoginRepo cadLoginRepo;

  @GetMapping("/login")
  public String login() {
    return "Paginas/login";
  }

  @PostMapping("/validar")
  public String validar(CadastroLogin confirmar, HttpSession session,
   RedirectAttributes aviso) {
    CadastroLogin confirmacao = this.cadLoginRepo.login(confirmar.getEmail(), Criptografia.md5cripto(confirmar.getSenha()));
    if (confirmacao != null) {
      session.setAttribute("secaoIniciada", confirmacao);
      return "redirect:/arealogin";
    } else {
      aviso.addFlashAttribute("mensagem", "Email ou senha inválidos, tente novamente");
      return "redirect:/login";
    }

  }

  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login";
  }
}
