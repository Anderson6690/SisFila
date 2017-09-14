package com.developlus.sisfila.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.service.CidadeService;

@Named
@RequestScoped
public class PesquisaCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeService cidadeService;

	private Cidade cidade;
	private List<Cidade> cidades;

	@PostConstruct
	public void init() {
		this.listar();
	}

	public void novo() {
		this.cidade = new Cidade();
	}

	public void listar() {
		this.cidades = cidadeService.listar();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public boolean isCidadeSelecionado() {
		return this.cidade != null;
	}

}
