package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developlus.sisfila.model.Funcionario;
import com.developlus.sisfila.repository.helper.FuncionarioQueries;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, FuncionarioQueries {

}
