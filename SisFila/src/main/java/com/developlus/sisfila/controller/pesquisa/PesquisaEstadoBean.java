package com.developlus.sisfila.controller.pesquisa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.developlus.sisfila.filter.EstadoFilter;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.service.EstadoService;

@Named
@RequestScoped
public class PesquisaEstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoService estadoService;

	private EstadoFilter filter;
	private Estado estado;
	private List<Estado> estados;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public PesquisaEstadoBean() {
		this.filter = new EstadoFilter();
	}

	public void novo() {
		this.estado = new Estado();
	}

	public void listar() {
		this.estados = estadoService.listar();
	}

	public void pesquisar() {
		this.estados = this.estadoService.filtrar(filter);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public boolean isEstadoSelecionado() {
		return this.estado != null;
	}

	public EstadoFilter getFilter() {
		return filter;
	}

	public void setFilter(EstadoFilter filter) {
		this.filter = filter;
	}

}
