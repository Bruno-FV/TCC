package com.tcc.laboratorioVida.Repository;

import org.springframework.data.repository.CrudRepository;

import com.tcc.laboratorioVida.Models.Contato;

public interface ContatoRepo extends CrudRepository<Contato,String> {
    
}
