package com.tcc.laboratorioVida.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.laboratorioVida.Models.AgendamentoConsultas;
import com.tcc.laboratorioVida.Models.AgendamentoExames;
import com.tcc.laboratorioVida.Models.CadastroConsultas;
import com.tcc.laboratorioVida.Models.CadastroExames;
import com.tcc.laboratorioVida.Models.Contato;
import com.tcc.laboratorioVida.Repository.AgendamentoConsultasRepo;
import com.tcc.laboratorioVida.Repository.AgendamentoExamesRepo;
import com.tcc.laboratorioVida.Repository.CadConsultasRepo;
import com.tcc.laboratorioVida.Repository.CadExamesRepo;
import com.tcc.laboratorioVida.Repository.ContatoRepo;

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

    @Autowired
    private AgendamentoConsultasRepo agendamentoConsultasRepo;

     @Autowired
    private AgendamentoExamesRepo agendamentoExamesRepo;

    @Autowired
    private ContatoRepo contatoRepo;
    
    @GetMapping("/administracao")
    public String administracao(HttpServletResponse response, HttpSession session,
    HttpServletRequest request, Model model){
        
/**************buscar todas as especialidades e medicos cadastrados *****************************************************/
    Iterable<CadastroConsultas> especialidadeMedicos =  consultasRepo.findAll(); 
    model.addAttribute("especialidadeMedicos", especialidadeMedicos);
        
/***************buscar todos os exames cadastrados***********************************************************************/
    Iterable<CadastroExames> tiposExames =  examesRepo.findAll(); 
    model.addAttribute("tiposExames", tiposExames);

/***************Buscar todos os agendamentos de consultas solicitados do usuario logado********************************************/
    Iterable<AgendamentoConsultas> agendamentos = agendamentoConsultasRepo.findAll();
    model.addAttribute("agendamentos", agendamentos);

/***************Buscar todos os agendamentos de exames solicitados do usuario logado********************************************/
    Iterable<AgendamentoExames>agendamentosExames = agendamentoExamesRepo.findAll();
    model.addAttribute("agendamentoExames", agendamentosExames);

    
   

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
    @PostMapping("/agendarConsultasAtendimento")
    public String agendarConsultas(AgendamentoConsultas agendamentoConsultas){  
        agendamentoConsultasRepo.save(agendamentoConsultas);  
        return "redirect:/administracao";
    } 
    @PostMapping("/adicionarConsultas")
    public String cadConsultas(CadastroConsultas consultas, Model model){
        consultasRepo.save(consultas);
        model.addAttribute("mensagem", "Consulta Salva com sucesso");
        return "redirect:/administracao";
    }
    @PostMapping("/adcionarExames")
    public String cadExames(CadastroExames exames){
        examesRepo.save(exames);
        return "redirect:/administracao";
    }
    @PostMapping("/agendarExamesAtendimento")
    public String agendarExames(AgendamentoExames exames){
        agendamentoExamesRepo.save(exames);
        return "redirect:/administracao";
    }
    @PostMapping("/atualizarContato")
    public String contato(Contato contato){
        contatoRepo.save(contato);
        return "redirect:/administracao";
    }
     @PostMapping("/removerContato")
    public String contatoDelete(Contato contatos){
        Iterable<Contato>contato = contatoRepo.findAll();
        if(((Contato) contato).getEmail() == contatos.getEmail()){
            contatoRepo.delete(contatos);
        }
        
        return "redirect:/administracao";
    }
}
