package com.developlus.sisfila.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.enums.Sexo;
import com.developlus.sisfila.filter.FuncionarioFilter;
import com.developlus.sisfila.model.Funcionario;
import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.model.Usuario;
import com.developlus.sisfila.service.FuncionarioService;
import com.developlus.sisfila.service.GrupoService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.service.UsuarioService;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private GrupoService grupoService;

	@Inject
	private FuncionarioService funcionarioService;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.usuario = new Usuario();
	}

	public void salvar() {
		try {

			this.usuarioService.salvar(usuario);
			FacesUtil.addSuccessMessage("Usuário salvo com sucesso!");

			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGrupos() {
		return grupoService.listar();
	}

	public List<Funcionario> completarFuncionario(String nome) {
		FuncionarioFilter funcioarioFilter = new FuncionarioFilter();
		funcioarioFilter.setNome(nome);
		return funcionarioService.filtrar(funcioarioFilter);
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

}
