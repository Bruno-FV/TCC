package com.tcc.laboratorioVida.Models;


import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamentos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String paciente;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private String especialidade;
    private String medicos;
    private String valorConsulta;
    private Date dataAgendamentoConsulta;
    private String horarioConsulta;
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
        this.paciente = paciente;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedicos() {
        return this.medicos;
    }

    public void setMedicos(String medicos) {
        this.medicos = medicos;
    }

    public String getValorConsulta() {
        return this.valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Date getDataAgendamentoConsulta() {
        return this.dataAgendamentoConsulta;
    }

    public void setDataAgendamentoConsulta(Date dataAgendamentoConsulta) {
        this.dataAgendamentoConsulta = dataAgendamentoConsulta;
    }

    public String getHorarioConsulta() {
        return this.horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getMedicoSolicitante() {
        return this.medicoSolicitante;
    }

    public void setMedicoSolicitante(String medicoSolicitante) {
        this.medicoSolicitante = medicoSolicitante;
    }

    public String getTipoExame() {
        return this.tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getValorExame() {
        return this.valorExame;
    }

    public void setValorExame(String valorExame) {
        this.valorExame = valorExame;
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
        this.horarioExame = horarioExame;
    }


}
