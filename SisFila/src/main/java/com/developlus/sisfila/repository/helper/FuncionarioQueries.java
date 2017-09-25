package com.developlus.sisfila.repository.helper;

import java.util.List;

import com.developlus.sisfila.filter.FuncionarioFilter;
import com.developlus.sisfila.model.Funcionario;

public interface FuncionarioQueries {

	public List<Funcionario> filtrar(FuncionarioFilter filtro);
}
