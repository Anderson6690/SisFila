package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.enums.Sexo;
import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.model.Funcionario;
import com.developlus.sisfila.service.CidadeService;
import com.developlus.sisfila.service.FuncionarioService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;

	@Inject
	private CidadeService cidadeService;

	private Funcionario funcionario;

	@PostConstruct
	private void init() {
		this.novo();
	}

	public void novo() {
		this.funcionario = new Funcionario();
	}

	public void salvar() {
		try {
			this.funcionarioService.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionário salvo com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Cidade> getCidades() {
		return cidadeService.listar();
	}

}
