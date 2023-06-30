package com.tcc.laboratorioVida.Controllers;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.laboratorioVida.Models.AgendamentoConsultas;
import com.tcc.laboratorioVida.Models.AgendamentoExames;
import com.tcc.laboratorioVida.Models.CadastroConsultas;
import com.tcc.laboratorioVida.Models.CadastroExames;
import com.tcc.laboratorioVida.Models.CadastroLogin;
import com.tcc.laboratorioVida.Repository.AgendamentoConsultasRepo;
import com.tcc.laboratorioVida.Repository.AgendamentoExamesRepo;

import com.tcc.laboratorioVida.Repository.CadConsultasRepo;
import com.tcc.laboratorioVida.Repository.CadExamesRepo;
import com.tcc.laboratorioVida.Repository.CadLoginRepo;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class AreaLoginController {
    

    @Autowired
    private AgendamentoConsultasRepo agendamentoConsultasRepo;

    @Autowired
    private AgendamentoExamesRepo agendamentoExamesRepo;

    @Autowired
    CadConsultasRepo consultasRepo;

    @Autowired
    CadExamesRepo examesRepo;

    @Autowired
    CadLoginRepo cadLoginRepo;
    

    @GetMapping("/arealogin")
    public String arealogin(HttpServletResponse response, HttpSession session,
    HttpServletRequest request, Model model, CadastroLogin cad) {

 /*************zerar o cache do navegar para impedir que após efetuar logof não retornar para area logada *******************/
    final String cacheControl = "Cache-Control";
    response.setHeader(cacheControl, "no-cache, no-store, must-revalidate");
    response.setHeader(cacheControl, "no-cache");
    response.setHeader(cacheControl, "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    session = request.getSession(false);
 /*************************************************************************************************************************/
                
         
 /**************buscar todas as especialidades e medicos cadastrados *****************************************************/
    Iterable<CadastroConsultas> especialidadeMedicos =  consultasRepo.findAll(); 
    model.addAttribute("especialidadeMedicos", especialidadeMedicos);

/***************buscar todos os exames cadastrados***********************************************************************/
    Iterable<CadastroExames> tiposExames =  examesRepo.findAll(); 
    model.addAttribute("tiposExames", tiposExames);

/***************Buscar todos os agendamentos solicitados do usuario logado**********************************************/
    Object userLogado = session.getAttribute("secaoIniciada");
    if(((CadastroLogin) userLogado).getEmail() == null){

        return "redirect:/login";

    }else{

        Iterable<AgendamentoConsultas> agendamentos = agendamentoConsultasRepo.findAll();
        List<AgendamentoConsultas> agendamentosFiltrados = StreamSupport.stream(agendamentos.spliterator(), false)
        .filter(a -> a.getEmail().equals(((CadastroLogin) userLogado).getEmail()))
        .collect(Collectors.toList());
        
        model.addAttribute("agendamentos", agendamentosFiltrados);
        
    }
    
/****************Buscar todos os Exames solicitados do usuario logado**************************************************/
    if(((CadastroLogin) userLogado).getEmail() == null){

        return "redirect:/login";

    }else{
        
    Iterable<AgendamentoExames> exames = agendamentoExamesRepo.findAll();
    List<AgendamentoExames> examesFiltrados = StreamSupport.stream(exames.spliterator(),false)
    .filter(e -> e.getEmail().equals(((CadastroLogin) userLogado).getEmail()))
    .collect(Collectors.toList());

    model.addAttribute("exames", examesFiltrados);
    }
                
/***************Verificar se o usuario esta logado*********************************************************************/
    if (session.getAttribute("secaoIniciada") != null) {
        return "Paginas/arealogin";// A sessão está ativa e o usuário está logado.
    } else {

        return "redirect:/login";// A sessão não está ativa ou o usuário não está logado.
    }
    }

    @PostMapping("/agendarConsultas")
    public String agendarConsultas(AgendamentoConsultas agendamentoConsultas){  
        agendamentoConsultasRepo.save(agendamentoConsultas);  
        return "redirect:/arealogin";
    } 
   
    @PostMapping("/agendarExames")
    public String agendarConsultas(AgendamentoExames agendamentoExames){
        agendamentoExamesRepo.save(agendamentoExames);
        return "redirect:/arealogin";
    }

}
