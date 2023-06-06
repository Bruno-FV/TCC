package com.tcc.laboratorioVida.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AgendamentoExames implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private CadastroLogin cadastroLogin; 
    @ManyToOne
    private CadastroAdmin cadastroAdmin;
    private String paciente;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private String medicoSolicitante;
    private String tipoExame;
    private String valorExame;
    private Date dataAgendamentoExame;
    private String horarioExame;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaciente() {
        return this.paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente.trim();
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMedicoSolicitante() {
        return this.medicoSolicitante;
    }

    public void setMedicoSolicitante(String medicoSolicitante) {
        this.medicoSolicitante = medicoSolicitante.trim();
    }

    public String getTipoExame() {
        return this.tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame.trim();
    }

    public String getValorExame() {
        return this.valorExame;
    }

    public void setValorExame(String valorExame) {
        this.valorExame = valorExame.trim();
    }

    public Date getDataAgendamentoExame() {
        return this.dataAgendamentoExame;
    }

    public void setDataAgendamentoExame(Date dataAgendamentoExame) {
        this.dataAgendamentoExame = dataAgendamentoExame;
    }

    public String getHorarioExame() {
        return this.horarioExame;
    }

    public void setHorarioExame(String horarioExame) {
        this.horarioExame = horarioExame.trim();
    }

}
