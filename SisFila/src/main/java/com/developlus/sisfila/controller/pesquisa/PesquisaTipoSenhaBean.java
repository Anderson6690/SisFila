package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.TipoSenha;
import com.developlus.sisfila.service.TipoSenhaService;

@Named
@RequestScoped
public class PesquisaTipoSenhaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoSenhaService tipoSenhaService;

	private TipoSenha tipoSenha;
	private List<TipoSenha> tiposSenha;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void listar() {
		this.tiposSenha = tipoSenhaService.listar();
	}

	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public List<TipoSenha> getTiposSenha() {
		return tiposSenha;
	}

	public boolean isTipoSenhaSelecionada() {
		return this.tipoSenha != null;
	}

}
