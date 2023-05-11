package com.tcc.laboratorioVida.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcc.laboratorioVida.Models.CadastroLogin;

public interface CadLoginRepo extends CrudRepository<CadastroLogin, String> {

    @Query(value = "select * from cadastro_login where email = :email and senha = :senha", nativeQuery = true)
    public CadastroLogin login(String email, String senha);

    @Query(value = "select * from cadastro_login where email = :email", nativeQuery = true)
    public CadastroLogin verificarEmail(String email);

}
