package com.developlus.sisfila.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.service.CidadeService;
import com.developlus.sisfila.service.EstadoService;
import com.developlus.sisfila.service.NegocioException;
import com.developlus.sisfila.util.jsf.FacesUtil;

@Named
@RequestScoped
public class CadastroCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeService cidadeService;
	
	@Inject EstadoService estadoService;

	private Cidade cidade;

	@PostConstruct
	public void init() {
		this.novo();
	}

	public void novo() {
		this.cidade = new Cidade();
	}

	public void salvar() {
		try {
			this.cidadeService.salvar(cidade);
			FacesUtil.addSuccessMessage("Cidade Salva com Sucesso");
			
			this.novo();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Estado> getEstados(){
		return estadoService.listar();
	}

}
