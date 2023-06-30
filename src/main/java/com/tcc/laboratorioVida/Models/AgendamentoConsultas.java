package com.tcc.laboratorioVida.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AgendamentoConsultas implements Serializable {
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

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade.trim();
    }

    public String getMedicos() {
        return this.medicos;
    }

    public void setMedicos(String medicos) {
        this.medicos = medicos.trim();
    }

    public String getValorConsulta() {
        return this.valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta.trim();
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
        this.horarioConsulta = horarioConsulta.trim();
    }

}
