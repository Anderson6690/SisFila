package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Funcionario;
import com.developlus.sisfila.service.FuncionarioService;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;

	@PostConstruct
	private void init() {
		this.listar();
	}

	public void novo() {
		this.funcionario = new Funcionario();
	}

	public void listar() {
		this.funcionarios = funcionarioService.listar();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public boolean isFuncionarioSelecionado() {
		return this.funcionario != null;
	}

}
