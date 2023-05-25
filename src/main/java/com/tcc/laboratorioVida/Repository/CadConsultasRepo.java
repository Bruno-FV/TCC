package com.tcc.laboratorioVida.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcc.laboratorioVida.Models.CadastroConsultas;



public interface CadConsultasRepo extends CrudRepository<CadastroConsultas, String> {
    
    /*@Query(value = "select * from cadastro_consultas where medico = :medico", nativeQuery = true)
    /*public CadastroConsultas registro(String medico); */
}
