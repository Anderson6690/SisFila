package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.developlus.sisfila.filter.FuncionarioFilter;
import com.developlus.sisfila.model.Funcionario;
import com.developlus.sisfila.repository.FuncionarioRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class FuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioRepository funcionarioRepository;

	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {

		if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")) {
			throw new NegocioException("O nome é obrigatório");
		}

		funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}

	public List<Funcionario> filtrar(FuncionarioFilter filtro) {
		return funcionarioRepository.filtrar(filtro);
	}

}
