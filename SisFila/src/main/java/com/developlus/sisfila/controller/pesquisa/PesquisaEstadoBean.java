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

	private EstadoFilter filtrar;
	private Estado estado;
	private List<Estado> estados;

	@PostConstruct
	public void init() {
		this.listar();
	}
	
	public PesquisaEstadoBean(){
		this.filtrar = new EstadoFilter();
	}

	public void novo() {
		this.estado = new Estado();
	}

	public void listar() {
		this.estados = estadoService.listar();
	}
	
	public void pesquisar(){
		System.out.println(" \n -- "+filtrar);

		this.estados = this.estadoService.filtrar(filtrar);
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

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public boolean isEstadoSelecionado() {
		return this.estado != null;
	}

	public EstadoFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(EstadoFilter filtrar) {
		this.filtrar = filtrar;
	}
	

}
