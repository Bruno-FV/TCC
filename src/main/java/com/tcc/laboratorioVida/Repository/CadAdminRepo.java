package com.tcc.laboratorioVida.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcc.laboratorioVida.Models.CadastroAdmin;


public interface CadAdminRepo extends CrudRepository<CadastroAdmin, Long> {
    
    @Query(value = "select * from cadastro_admin where email = :email and senha = :senha", nativeQuery = true)
    public CadastroAdmin loginAdmin(String email, String senha); 
    
    @Query(value = "select * from cadastro_admin where email = :email", nativeQuery = true)
    public CadastroAdmin verificarEmailAdmin(String email);
}
