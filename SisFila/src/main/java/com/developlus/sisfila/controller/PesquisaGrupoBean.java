package com.developlus.sisfila.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.service.GrupoService;

@Named
@RequestScoped
public class PesquisaGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;

	private Grupo grupo;
	private List<Grupo> grupos;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void listar() {
		this.grupos = grupoService.listar();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public boolean isGrupoSelecionado() {
		return this.grupo != null;
	}

}
