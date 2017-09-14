package com.developlus.sisfila.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.model.Usuario;
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

	public List<Grupo> getPermissoes() {
		return grupoService.listar();
	}

}
